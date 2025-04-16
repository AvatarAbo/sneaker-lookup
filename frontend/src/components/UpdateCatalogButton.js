import React from 'react';

const UpdateCatalogButton = ({ handleUpdateButtonClicked }) => {
    return (
        <button onClick={handleUpdateButtonClicked}>
            Update
        </button>
    );
};

export default UpdateCatalogButton;