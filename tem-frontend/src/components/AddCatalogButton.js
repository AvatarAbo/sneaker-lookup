import React from 'react';

//use props object for practice
const AddCatalogButton = (props) => {
    return (
        <button onClick={props.handleAddButtonClicked}>
            Add Sneaker
        </button>
    );
};

export default AddCatalogButton;