import React, { useState , useEffect } from 'react';
import { getAvgMarketValue } from '../services/api';
import useGetCatalogConstants from '../hooks/useGetCatalogConstants';

const UpdateCatalogForm = ({ sneaker , catalog , handleSubmit , handleCancel }) => {
    const [shoeSize, setShoeSize] = useState(catalog.shoeSize);
    const [yearAcquired, setYearAcquired] = useState(catalog.yearAcquired);
    const [condition, setCondition] = useState(catalog.condition);
    const [marketValue, setMarketValue] = useState(catalog.marketValue);

    const [years, setYears] = useState([]);
    const {sizes, conditionValues} = useGetCatalogConstants();

    useEffect(() => {
        const fetchPossibleYearsSneakerWasAcquired = async () => {
            const yearOptions = [];
            const currentYear = new Date().getFullYear();
            for (let year = currentYear; year >= sneaker.year; year--) {
                yearOptions.push(year);
            }
            setYears(yearOptions);
        };
        fetchPossibleYearsSneakerWasAcquired();
    }, []);

    useEffect(() => {
        const fetchMarketValue = async () => {
            try {
                const avgMarketValueResponse = await getAvgMarketValue(sneaker.sneakerId);
                const avgMarketValue = avgMarketValueResponse.marketValue;
                //console.log('calculated avgMarketValue:', avgMarketValue);

                const conditionMultiplier = conditionValues[condition] / 5;
                //console.log('calculated conditionMultiplier:', conditionMultiplier);

                let value = (avgMarketValue * conditionMultiplier).toFixed(2);
                setMarketValue(value);
                //console.log('calculated marketValue:', value);
            } catch (error) {
                console.error('Error fetching market value:', error);
            }
        };

        fetchMarketValue();
    }, [condition]);

    const onSubmit = async (e) => {
        e.preventDefault();
        handleSubmit({ catalogId: catalog.catalogId, sneakerId: sneaker.sneakerId, shoeSize, yearAcquired, condition, marketValue });
    };

    return (
        <form onSubmit={onSubmit}>
            <h3>Update Sneaker</h3>
            <div>
                <label>Sneaker: {sneaker.year} {sneaker.brand} {sneaker.model} {sneaker.colorWay} </label>
            </div>
            <div>
                <label>Shoe Size (US Mens) </label>
                <select value={shoeSize} onChange={(e) => setShoeSize(e.target.value)} required>
                    {sizes.map(size => (<option key={size} value={size}>{size}</option>))}
                </select>
            </div>
            <div>
                <label>Year Acquired </label>
                <select value={yearAcquired} onChange={(e) => setYearAcquired(e.target.value)} required>
                    {years.map(year => (<option key={year} value={year}>{year}</option>))}
                </select>
            </div>
            <div>
                <label>Condition </label>
                <select value={condition} onChange={(e) => setCondition(e.target.value)} required>
                    {Object.keys(conditionValues).map(condition => (<option key={condition} value={condition}>{condition}</option>))}
                </select>
            </div>
            <div>
                <label>Updated Market Value: {marketValue} </label>
            </div>
            <button type="submit">Update</button>
            <button type="button" onClick={handleCancel}>Cancel</button>
        </form>
    );
};

export default UpdateCatalogForm;