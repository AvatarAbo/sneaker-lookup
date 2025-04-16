import React, { useState , useContext } from 'react';
import UpdateCatalogButton from './UpdateCatalogButton';
import UpdateCatalogForm from './UpdateCatalogForm';
import DeleteCatalogButton from './DeleteCatalogButton';
import { SneakerContext } from '../App';

//destructuring props example
const CatalogList = ({ showUpdateCatalogButton , showUpdateCatalogForm , hideUpdateCatalogForm ,
        handleUpdateButtonClicked , updateCatalogId , handleUpdateCatalog , showDeleteCatalogButton , handleDeleteCatalog }) => {

    const [selectedCatalogToUpdate, setSelectedCatalogToUpdate] = useState(null);
    const { sneakers , catalogs } = useContext(SneakerContext);

    return (
        <ul>
            {catalogs.map(catalog => {
                const sneaker = sneakers.find(sneaker => sneaker.sneakerId === catalog.sneakerId);
                return (
                    <li key={catalog.catalogId}>
                        {selectedCatalogToUpdate !== catalog && (
                            <>
                                <div>{sneaker ? `${sneaker.year} ${sneaker.brand} ${sneaker.model} ${sneaker.colorWay}` : 'Loading...'}</div>
                                <div>Size: {catalog.shoeSize}</div>
                                <div>Year Acquired: {catalog.yearAcquired}</div>
                                <div>Condition: {catalog.condition}</div>
                                <div>Market Value: ${catalog.marketValue.toFixed(2)}</div>

                                {showUpdateCatalogButton && <UpdateCatalogButton
                                    handleUpdateButtonClicked={
                                        () => {
                                            handleUpdateButtonClicked(catalog.catalogId);
                                            setSelectedCatalogToUpdate(catalog);
                                        }
                                    }
                                />}
                                {showDeleteCatalogButton && <DeleteCatalogButton handleDeleteButtonClicked={() => handleDeleteCatalog(catalog.catalogId)}/>}
                            </>
                        )}
                        {showUpdateCatalogForm && catalog.catalogId === updateCatalogId &&
                            <UpdateCatalogForm
                                sneaker={sneaker}
                                catalog={catalog}
                                handleSubmit={handleUpdateCatalog}
                                handleCancel={
                                    () => {
                                        hideUpdateCatalogForm();
                                        setSelectedCatalogToUpdate(null);
                                    }
                                }
                            />
                        }
                    </li>
                );
            })}
        </ul>
    );
};

export default CatalogList;