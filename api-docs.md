#API Docs

##Sorting
| param  | sample         | definition                                                                                           |
|--------|----------------|------------------------------------------------------------------------------------------------------|
| `page` | `page=0`       | positive or zero number value, selected page                                                         |
| `size` | `size=10`      | positive number value, selected count of items in page                                               |
| `sort` | `sort=id,desc` | sorting strategy, can use multiple times, `asc` - default ascending order, `desc` - descending order |    

`https://gateway.com/api/resources?page=2&size=50&sort=id,desc`

---

## Category Resources

### Columns
- `slug`
- `name`

---

### 🌟🌟🌟 Create Category `POST: [/api/categories]`

### Request Headers

- `Content-Type: application/json`

### Request Body

```json
{
    "slug": "football_station",
    "name": "Football Station",
    "parent_slug": null
}
```

| Attribute     |  Type  | Nullable | Description |
|---------------|:------:|:--------:|-------------|
| `slug`        | string |    ❌     | max: 255    |
| `name`        | string |    ❌     | max: 255    |
| `parent_slug` | string |    ✅     | max: 255    |

### Response Headers

- `Content-Type: application/json`

### Response

- Response status `201 CREATED` 📦
- Body 👇
```json
{
  "slug": "football_station",
  "name": "Football Station",
  "parent": null,
  "categories": []
}
```

---

## Address Resources

### Columns
- `id`
- `region` 
- `street`
- `lat`
- `lng`
- `zipCode`

---

### 🌟🌟🌟 Create Address `POST: [/api/addresses]`

### Request Headers

- `Content-Type: application/json`

### Request Body

```json
{
  "region": "tashkent",
  "street": "Mirzo Ulug'bek",
  "zip_code": "100024",
  "lat": 12.34321,
  "lng": 12.33212,
  "category_slug": "football_station"
}
```

| Attribute       |     Type      | Nullable | Description | 
|:----------------|:-------------:|:--------:|-------------|
| `region`        |    string     |    ✅     | max: 255    |
| `street`        |    string     |    ✅     | max: 255    |
| `zip_code`      |    string     |    ✅     | max: 255    |
| `lat`           | decimal(10,8) |    ✅     |             |
| `lon`           | decimal(11,8) |    ✅     |             |
| `category_slug` |     long      |    ❌     | max: 255    | 

### Response Headers

- `Content-Type: application/json`

### Response

- Response status `201 CREATED` 📦
- Body 👇
```json
{
  "id": 1,
  "region": "tashkent",
  "street": "Mirzo Ulug'bek",
  "zip_code": "100024",
  "lat": 12.34321,
  "lon": 12.33212,
  "images": [],
  "categories": []
}
```

---

### 🌟🌟🌟 Partial Update Address `PATCH [/api/addresses/{id}]`

### Request Headers

- `Content-Type: application/json`

### Path variables

- `id` id of address

### Request Body

```json
{
    "region": "tashkent",
    "street": "Amir Temur",
    "zip_code": "100025",
    "lat": 42.243253,
    "lng": 42.243253,
    "category_slug": "tashkent"
}
```

| Attribute       |     Type      | Nullable | Description | 
|:----------------|:-------------:|:--------:|-------------|
| `region`        |    string     |    ✅     | max: 255    |
| `street`        |    string     |    ✅     | max: 255    |
| `zip_code`      |    string     |    ✅     | max: 255    |
| `lat`           | decimal(10,8) |    ✅     |             |
| `lon`           | decimal(11,8) |    ✅     |             |
| `category_slug` |    string     |    ❌     | max: 255    |

### Response Headers

- `Content-Type: application/json`

### Response

- Response status `200 OK` 👌
- Body 👇
```json
{
  "id": 1,
  "region": "tashkent",
  "street": "Amir Temur",
  "zip_code": "100025",
  "lat": 42.243253,
  "lon": 12.33212000,
  "images": [],
  "categories": [
    {
      "slug": "football_station",
      "name": "Football Station",
      "parent_slug": null
    }
  ]
}
```

---

### 🌟🌟🌟 Delete Address `DELETE [/api/addresses/{id}]`

### Path variables

- `id` - id of address

### Response

- Response status `204 NO_CONTENT` 🍽

---

### 🌟🌟🌟 Get Addresses `GET [/api/addresses]`

### Response

- Response status `200 OK` 👌
- Body 👇
```json
{
  "content": [
    {
      "id": 1,
      "region": "tashkent",
      "street": "Amir Temur",
      "zip_code": "100025",
      "lat": 42.24325300,
      "lon": 12.33212000,
      "images": [],
      "categories": [
        {
          "slug": "football_station",
          "name": "Football Station",
          "parent_slug": null
        }
      ]
    }
  ],
  "pageable": {
    "sort": {
      "sorted": false,
      "unsorted": true,
      "empty": true
    },
    "pageNumber": 0,
    "pageSize": 20,
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "totalPages": 1,
  "totalElements": 1,
  "last": true,
  "first": true,
  "sort": {
    "sorted": false,
    "unsorted": true,
    "empty": true
  },
  "number": 0,
  "numberOfElements": 1,
  "size": 20,
  "empty": false
}
```