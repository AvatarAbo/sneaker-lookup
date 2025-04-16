# SneakerLookup (java)
#edit this later
## Introduction
SneakerLookup is a sample Java/Spring API. SneakerLookup is an application for managing sneaker catalogs. 
Using SneakerLookup, users can add, update, delete, and retrieve information about various sneakers in their collection.

## Entities
### Catalog
Represents a catalog entry for a sneaker.

### Sneaker
Represents a sneaker with details like brand, model, and colorway.

### Product
Represents a product entry for a sneaker found within a store.

## API endpoints
### GET /api/catalog
Returns all catalog entries.

### GET /api/catalog/{id}
Returns a catalog entry by its ID.

### GET /api/catalog/getCatalogs
Returns catalog entries by sneaker ID.

### POST /api/catalog
Creates a new catalog entry.

### PUT /api/catalog/update
Updates an existing catalog entry.

### DELETE /api/catalog/remove/{id}
Deletes an existing catalog entry, given its ID.

### GET /api/sneaker
Returns all sneakers.

### GET /api/sneaker/getById/{id}
Returns a sneaker by its ID.

### GET /api/sneaker/search
Returns sneakers given a year, brand, model, and/or colorway.

### POST /api/sneaker
Creates a new sneaker entry.

### GET /api/product
Returns all products.  

### GET /api/product/{id}
Returns a product by its ID.  

### GET /api/product/getProducts
Returns products given a sneaker ID.  

### POST /api/product
Creates a new product entry.  

### PATCH /api/product/updateQuantity/{storeId}/{sneakerId}/{shoeSize}/{quantity}
Updates the quantity of an existing product entry, given the store ID, sneaker ID, shoe size and new quantity.  

### PATCH /api/product/updateQuantity/{storeId}/{sneakerId}/{shoeSize}/{price}
Updates the price of an existing product entry, given the store ID, sneaker ID, shoe size and new price.  

### GET /api/product/getMarketPrice/{sneakerId}
Returns the average market price of a sneaker, given the sneaker ID.