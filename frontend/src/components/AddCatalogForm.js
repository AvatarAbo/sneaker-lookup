import React, { useState , useEffect , useContext } from 'react';
import { getSneakerById , getAvgMarketValue } from '../services/api';
import useGetCatalogConstants from '../hooks/useGetCatalogConstants';
import { SneakerContext } from '../App';

const CatalogForm = ({ handleSubmit , handleCancel }) => {
    const { sneakers } = useContext(SneakerContext);

    const [sneakerId, setSneakerId] = useState('');
    const [shoeSize, setShoeSize] = useState('');
    const [yearAcquired, setYearAcquired] = useState('');
    const [condition, setCondition] = useState('');

    const [years, setYears] = useState([]);
    const {sizes, conditionValues} = useGetCatalogConstants();

    useEffect(() => {
        const fetchPossibleYearsSneakerWasAcquired = async () => {
            if (sneakerId !== '') {
                try {
                    const sneaker = await getSneakerById(sneakerId);
                    const currentYear = new Date().getFullYear();

                    const yearOptions = [];
                    for (let year = currentYear; year >= sneaker.year; year--) {
                        yearOptions.push(year);
                    }
                    setYears(yearOptions);
                } catch (error) {
                    console.error('Error fetching sneakers:', error);
                }
            } else {
                setYears([]);
            }
        };

        fetchPossibleYearsSneakerWasAcquired();
    }, [sneakerId]);

    const onSubmit = async (e) => {
        e.preventDefault();
        const avgMarketValueResponse = await getAvgMarketValue(sneakerId);
        const avgMarketValue = avgMarketValueResponse.marketValue;
        //console.log('calculated avgMarketValue:', avgMarketValue);

        const conditionMultiplier = conditionValues[condition] / 5;
        //console.log('calculated conditionMultiplier:', conditionMultiplier);

        let marketValue = (avgMarketValue * conditionMultiplier).toFixed(2);
        //console.log('calculated marketValue:', marketValue);

        handleSubmit({ sneakerId, shoeSize, yearAcquired, condition, marketValue });
    };

    return (
        <form onSubmit={onSubmit}>
            <h3>Add Sneaker</h3>
            <div>
                <label>Sneaker </label>
                <select
                    value={sneakerId}
                    onChange={(e) => setSneakerId(e.target.value)}
                    required
                >
                <option value="">Select sneaker</option>
                    {sneakers.map(sneaker => {
                        const sneakerName = `${sneaker.year} ${sneaker.brand} ${sneaker.model} ${sneaker.colorWay}`;
                        return <option key={sneaker.sneakerId} value={sneaker.sneakerId}>{sneakerName}</option>;
                    })}
                </select>
            </div>
            <div>
                <label>Shoe Size (US Mens) </label>
                <select value={shoeSize} onChange={(e) => setShoeSize(e.target.value)} required>
                    <option value="">Select shoe size</option>
                        {sizes.map(size => (<option key={size} value={size}>{size}</option>))}
                </select>
            </div>
            <div>
                <label>Year Acquired </label>
                <select value={yearAcquired} onChange={(e) => setYearAcquired(e.target.value)} required>
                    <option value="">Select year</option>
                        {years.map(year => (<option key={year} value={year}>{year}</option>))}
                </select>
            </div>
            <div>
                <label>Condition </label>
                <select value={condition} onChange={(e) => setCondition(e.target.value)} required>
                    <option value="">Select condition</option>
                        {Object.keys(conditionValues).map(condition => (<option key={condition} value={condition}>{condition}</option>))}
                </select>
            </div>
            <button type="submit">Add</button>
            <button type="button" onClick={handleCancel}>Cancel</button>
        </form>
    );
};

export default CatalogForm;