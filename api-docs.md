#API Docs

##Sorting
| param  | sample         | definition                                                                                           |
|--------|----------------|------------------------------------------------------------------------------------------------------|
| `page` | `page=0`       | positive or zero number value, selected page                                                         |
| `size` | `size=10`      | positive number value, selected count of items in page                                               |
| `sort` | `sort=id,desc` | sorting strategy, can use multiple times, `asc` - default ascending order, `desc` - descending order |    

`https://gateway.com/api/resources?page=2&size=50&sort=id,desc`

---

##Address Resources

###Columns
- `id`
- `region` 
- `street`
- `lon`
- `zipCode`
- `lat`

---

### 🌟🌟🌟 Create Address `POST: [/api/addresses]`

### Request Headers

- `Content-Type: application/json`

### Request Body

```json
{
    "region": "tashkent",
    "street": "Amir Temur",
    "zip_code": "120024",
    "lat": "42.243253",
    "lon": "42.243253",
    "category_id": 1
}
```

| Attribute     |   Type   | Nullable | Description | 
|:--------------|:--------:|:--------:|-------------|
| `region`      |  string  |    ✅     | max: 255    |
| `street`      |  string  |    ✅     | max: 255    |
| `zip_code`    |  string  |    ✅     | max: 255    |
| `lat`         |  string  |    ✅     | max: 255    |
| `lon`         |  string  |    ✅     | max: 255    |
| `category_id` |   long   |    ❌     | min: 1      | 

### Response Headers

- `Content-Type: application/json`

### Response

- Response status `201 CREATED` 📦
- Body 👇
```json
{
    "id": 1,
    "region": "tashkent",
    "street": "Amir Temur",
    "zip_code": "120024",
    "lat": "42.243253",
    "lon": "42.243253",
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
    "zip_code": "120024",
    "lat": "42.243253",
    "lon": "42.243253",
    "category_id": 1
}
```

| Attribute     |   Type   | Nullable | Description | 
|:--------------|:--------:|:--------:|-------------|
| `region`      |  string  |    ✅     | max: 255    |
| `street`      |  string  |    ✅     | max: 255    |
| `zip_code`    |  string  |    ✅     | max: 255    |
| `lat`         |  string  |    ✅     | max: 255    |
| `lon`         |  string  |    ✅     | max: 255    |
| `category_id` |   long   |    ✅     | min: 1      |

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
    "zip_code": "120024",
    "lat": "42.243253",
    "lon": "42.243253",
    "images": [],
    "categories": [] 
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
  "content":[
    {
      "id":1,
      "region":"23123123",
      "street":"2312312312",
      "zip_code":"231231",
      "lat":"1234321",
      "lon":"1233212",
      "images":[],
      "categories":[
        {
          "slug":"playground",
          "name":"Playground",
          "parent_id":null
        },
        {
          "slug":"football_station",
          "name":"Football Station",
          "parent_id":5
        }
      ]
    }
  ],
  "pageable":{
    "sort":{
      "sorted":false,
      "unsorted":true,
      "empty":true
    },
    "pageNumber":0,
    "pageSize":20,
    "offset":0,
    "paged":true,
    "unpaged":false
  },
  "totalPages":1,
  "totalElements":1,
  "last":true,
  "sort":{
    "sorted":false,
    "unsorted":true,
    "empty":true
  },
  "first":true,
  "number":0,
  "numberOfElements":1,
  "size":20,
  "empty":false
}
```