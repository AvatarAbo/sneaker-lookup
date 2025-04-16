import { useState, useEffect } from 'react';

const useGetCatalogConstants = () => {
    const [sizes, setSizes] = useState([]);

    const conditionValues = {
        DS: 5,
        VNDS: 4,
        GOOD: 3,
        FAIR: 2,
        POOR: 1
    };

    useEffect(() => {
        const possibleSizes = [];
        for (let size = 5; size <= 15; size += 0.5) {
            possibleSizes.push(size);
        }
        setSizes(possibleSizes);
    }, []);

    return {
        sizes,
        conditionValues
    };
};

export default useGetCatalogConstants;