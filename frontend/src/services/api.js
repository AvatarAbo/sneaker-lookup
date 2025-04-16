import axios from 'axios';

const API_URL = 'http://localhost:8080/api';

export const getAllSneakers = async () => {
    try {
        const response = await axios.get(`${API_URL}/sneaker`);
        return response.data;
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
};

export const getSneakerById = async (id) => {
    try {
        const response = await axios.get(`${API_URL}/sneaker/getById/${id}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
};

export const getSneakerByDetails = async (year, brand, model, colorWay) => {
    try {
        const response = await axios.get(`${API_URL}/sneaker/search?/year=${year}&brand=${encodeURIComponent(brand)}&model=${encodeURIComponent(model)}&colorWay=${encodeURIComponent(colorWay)}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
}

export const getAllCatalogs = async () => {
    try {
        const response = await axios.get(`${API_URL}/catalog`);
        return response.data;
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
};

export const getCatalogById = async (id) => {
    try {
        const response = await axios.get(`${API_URL}/catalog/${id}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
};

export const addCatalog = async (catalog) => {
    try {
        const response = await axios.post(`${API_URL}/catalog`, catalog);
        return response.data;
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
};

export const updateCatalog = async (catalog) => {
    try {
        const response = await axios.put(`${API_URL}/catalog/update`, catalog);
        return response.data;
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
}

export const deleteCatalog = async (id) => {
    try {
        const response = await axios.delete(`${API_URL}/catalog/remove/${id}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
}

export const getAvgMarketValue = async (id) => {
    try {
        const response = await axios.get(`${API_URL}/product/getMarketPrice/${id}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
};
