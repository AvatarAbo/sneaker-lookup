import React from 'react';

const DeleteCatalogButton = ({ handleDeleteButtonClicked }) => {
    return (
        <button onClick={handleDeleteButtonClicked}>
            Delete
        </button>
    );
};

export default DeleteCatalogButton;