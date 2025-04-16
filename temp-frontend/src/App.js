import React, { useState, useEffect, createContext } from 'react';
import CatalogList from './components/CatalogList';
import AddCatalogButton from './components/AddCatalogButton';
import AddCatalogForm from './components/AddCatalogForm';
import { getAllSneakers , getAllCatalogs , addCatalog , updateCatalog , deleteCatalog } from './services/api';

export const SneakerContext = createContext();

function App() {

    const [sneakers, setSneakers] = useState([]);
    const [catalogs, setCatalogs] = useState([]);

    const [showAddCatalogButton, setShowAddCatalogButton] = useState(true);
    const [showAddCatalogForm, setShowAddCatalogForm] = useState(false);

    const [showUpdateCatalogButton, setShowUpdateCatalogButton] = useState(true);
    const [showUpdateCatalogForm, setShowUpdateCatalogForm] = useState(false);
    const [updateCatalogId, setUpdateCatalogId] = useState('');

    const [showDeleteCatalogButton, setShowDeleteCatalogButton] = useState(true);

    useEffect(() => {
        getAllSneakers().then(response => {
            setSneakers(response.data);
        }).catch(error => {
            console.error('There was an error fetching the sneaker data!', error);
        });

        getAllCatalogs().then(response => {
            setCatalogs(response.data);
        }).catch(error => {
            console.error('There was an error fetching the catalog data!', error);
        });
    }, []);

    const handleAddButtonClicked = () => {
        setShowAddCatalogButton(false);
        setShowAddCatalogForm(true);
        setShowUpdateCatalogButton(false);
        setShowDeleteCatalogButton(false);
    }

    const hideAddCatalogForm = () => {
        setShowAddCatalogButton(true);
        setShowAddCatalogForm(false);
        setShowUpdateCatalogButton(true);
        setShowDeleteCatalogButton(true);
    };

    const handleUpdateButtonClicked = (id) => {
        setShowUpdateCatalogButton(false);
        setShowUpdateCatalogForm(true);
        setUpdateCatalogId(id);
        setShowAddCatalogButton(false);
        setShowDeleteCatalogButton(false);
    };

    const hideUpdateCatalogForm = () => {
        setShowUpdateCatalogButton(true);
        setShowUpdateCatalogForm(false);
        setShowAddCatalogButton(true);
        setShowDeleteCatalogButton(true);
    };

    const handleAddCatalog = async (newCatalog) => {
        try {
            console.log('Adding catalog:', newCatalog);
            await addCatalog({ data: newCatalog });
            const updatedCatalogs = await getAllCatalogs();
            setCatalogs(updatedCatalogs.data);
            hideAddCatalogForm();
        } catch (error) {
            console.error('Error adding catalog:', error);
        }
    };

    const handleUpdateCatalog = async (updatedCatalog) => {
        try {
            console.log('Updating catalog:', updatedCatalog);
            await updateCatalog({ data: updatedCatalog });
            const updatedCatalogs = await getAllCatalogs();
            setCatalogs(updatedCatalogs.data);
            hideUpdateCatalogForm();
        } catch (error) {
            console.error('Error updating catalog:', error);
        }
    };

    const handleDeleteCatalog = async (id) => {
        try {
            console.log('Deleting catalog with id', id);
            await deleteCatalog(id);
            const updatedCatalogs = await getAllCatalogs();
            setCatalogs(updatedCatalogs.data);
        } catch (error) {
            console.error('Error deleting catalog:', error);
        }
    };

    return (
        <SneakerContext.Provider value={{ sneakers, setSneakers, catalogs, setCatalogs }}>
            <header className="App-header">
                <h1>My Sneaker Collection</h1>
            </header>
            <CatalogList
                showUpdateCatalogButton={showUpdateCatalogButton}
                showUpdateCatalogForm={showUpdateCatalogForm}
                hideUpdateCatalogForm={hideUpdateCatalogForm}
                handleUpdateButtonClicked={handleUpdateButtonClicked}
                updateCatalogId={updateCatalogId}
                handleUpdateCatalog={handleUpdateCatalog}
                showDeleteCatalogButton={showDeleteCatalogButton}
                handleDeleteCatalog={handleDeleteCatalog}
            />
            {showAddCatalogButton && <AddCatalogButton handleAddButtonClicked={handleAddButtonClicked} />}
            {showAddCatalogForm && <AddCatalogForm handleSubmit={handleAddCatalog}
                handleCancel={hideAddCatalogForm} />}
        </SneakerContext.Provider>
    );
}

export default App;