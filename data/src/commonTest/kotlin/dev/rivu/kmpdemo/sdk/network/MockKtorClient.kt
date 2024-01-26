package dev.rivu.kmpdemo.sdk.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpStatusCode

const val JsonPlaceHoldersUsersUrl = "jsonplaceholder.typicode.com/users"
const val JsonPlaceHoldersUsersResponse = """
    [
  {
    "id": 1,
    "name": "Leanne Graham",
    "username": "Bret",
    "email": "Sincere@april.biz",
    "address": {
      "street": "Kulas Light",
      "suite": "Apt. 556",
      "city": "Gwenborough",
      "zipcode": "92998-3874",
      "geo": {
        "lat": "-37.3159",
        "lng": "81.1496"
      }
    },
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "company": {
      "name": "Romaguera-Crona",
      "catchPhrase": "Multi-layered client-server neural-net",
      "bs": "harness real-time e-markets"
    }
  },
  {
    "id": 2,
    "name": "Ervin Howell",
    "username": "Antonette",
    "email": "Shanna@melissa.tv",
    "address": {
      "street": "Victor Plains",
      "suite": "Suite 879",
      "city": "Wisokyburgh",
      "zipcode": "90566-7771",
      "geo": {
        "lat": "-43.9509",
        "lng": "-34.4618"
      }
    },
    "phone": "010-692-6593 x09125",
    "website": "anastasia.net",
    "company": {
      "name": "Deckow-Crist",
      "catchPhrase": "Proactive didactic contingency",
      "bs": "synergize scalable supply-chains"
    }
  }
]
"""

const val DummyJsonUsersUrl = "dummyjson.com/users"
const val DummyJsonUsersResponse = """
    {
  "users": [
    {
      "id": 1,
      "firstName": "Terry",
      "lastName": "Medhurst",
      "maidenName": "Smitham",
      "age": 50,
      "gender": "male",
      "email": "atuny0@sohu.com",
      "phone": "+63 791 675 8914",
      "username": "atuny0",
      "password": "9uQFF1Lh",
      "birthDate": "2000-12-25",
      "image": "https://robohash.org/Terry.png?set=set4",
      "bloodGroup": "A-",
      "height": 189,
      "weight": 75.4,
      "eyeColor": "Green",
      "hair": {
        "color": "Black",
        "type": "Strands"
      },
      "domain": "slashdot.org",
      "ip": "117.29.86.254",
      "address": {
        "address": "1745 T Street Southeast",
        "city": "Washington",
        "coordinates": {
          "lat": 38.867033,
          "lng": -76.979235
        },
        "postalCode": "20020",
        "state": "DC"
      },
      "macAddress": "13:69:BA:56:A3:74",
      "university": "Capitol University",
      "bank": {
        "cardExpire": "06/22",
        "cardNumber": "50380955204220685",
        "cardType": "maestro",
        "currency": "Peso",
        "iban": "NO17 0695 2754 967"
      },
      "company": {
        "address": {
          "address": "629 Debbie Drive",
          "city": "Nashville",
          "coordinates": {
            "lat": 36.208114,
            "lng": -86.58621199999999
          },
          "postalCode": "37076",
          "state": "TN"
        },
        "department": "Marketing",
        "name": "Blanda-O'Keefe",
        "title": "Help Desk Operator"
      },
      "ein": "20-9487066",
      "ssn": "661-64-2976",
      "userAgent": "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/12.0.702.0 Safari/534.24",
      "crypto": {
        "coin": "Bitcoin",
        "wallet": "0xb9fc2fe63b2a6c003f1c324c3bfa53259162181a",
        "network": "Ethereum (ERC20)"
      }
    },
    {
      "id": 2,
      "firstName": "Sheldon",
      "lastName": "Quigley",
      "maidenName": "Cole",
      "age": 28,
      "gender": "male",
      "email": "hbingley1@plala.or.jp",
      "phone": "+7 813 117 7139",
      "username": "hbingley1",
      "password": "CQutx25i8r",
      "birthDate": "2003-08-02",
      "image": "https://robohash.org/Sheldon.png?set=set4",
      "bloodGroup": "O+",
      "height": 187,
      "weight": 74,
      "eyeColor": "Brown",
      "hair": {
        "color": "Blond",
        "type": "Curly"
      },
      "domain": "51.la",
      "ip": "253.240.20.181",
      "address": {
        "address": "6007 Applegate Lane",
        "city": "Louisville",
        "coordinates": {
          "lat": 38.1343013,
          "lng": -85.6498512
        },
        "postalCode": "40219",
        "state": "KY"
      },
      "macAddress": "13:F1:00:DA:A4:12",
      "university": "Stavropol State Technical University",
      "bank": {
        "cardExpire": "10/23",
        "cardNumber": "5355920631952404",
        "cardType": "mastercard",
        "currency": "Ruble",
        "iban": "MD63 L6YC 8YH4 QVQB XHIK MTML"
      },
      "company": {
        "address": {
          "address": "8821 West Myrtle Avenue",
          "city": "Glendale",
          "coordinates": {
            "lat": 33.5404296,
            "lng": -112.2488391
          },
          "postalCode": "85305",
          "state": "AZ"
        },
        "department": "Services",
        "name": "Aufderhar-Cronin",
        "title": "Senior Cost Accountant"
      },
      "ein": "52-5262907",
      "ssn": "447-08-9217",
      "userAgent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.30 (KHTML, like Gecko) Ubuntu/11.04 Chromium/12.0.742.112 Chrome/12.0.742.112 Safari/534.30",
      "crypto": {
        "coin": "Bitcoin",
        "wallet": "0xb9fc2fe63b2a6c003f1c324c3bfa53259162181a",
        "network": "Ethereum (ERC20)"
      }
    },
    {
      "id": 3,
      "firstName": "Terrill",
      "lastName": "Hills",
      "maidenName": "Hoeger",
      "age": 38,
      "gender": "male",
      "email": "rshawe2@51.la",
      "phone": "+63 739 292 7942",
      "username": "rshawe2",
      "password": "OWsTbMUgFc",
      "birthDate": "1992-12-30",
      "image": "https://robohash.org/Terrill.png?set=set4",
      "bloodGroup": "A-",
      "height": 200,
      "weight": 105.3,
      "eyeColor": "Gray",
      "hair": {
        "color": "Blond",
        "type": "Very curly"
      },
      "domain": "earthlink.net",
      "ip": "205.226.160.3",
      "address": {
        "address": "560 Penstock Drive",
        "city": "Grass Valley",
        "coordinates": {
          "lat": 39.213076,
          "lng": -121.077583
        },
        "postalCode": "95945",
        "state": "CA"
      },
      "macAddress": "F2:88:58:64:F7:76",
      "university": "University of Cagayan Valley",
      "bank": {
        "cardExpire": "10/23",
        "cardNumber": "3586082982526703",
        "cardType": "jcb",
        "currency": "Peso",
        "iban": "AT24 1095 9625 1434 9703"
      },
      "company": {
        "address": {
          "address": "18 Densmore Drive",
          "city": "Essex",
          "coordinates": {
            "lat": 44.492953,
            "lng": -73.101883
          },
          "postalCode": "05452",
          "state": "VT"
        },
        "department": "Marketing",
        "name": "Lindgren LLC",
        "title": "Mechanical Systems Engineer"
      },
      "ein": "48-3951994",
      "ssn": "633-89-1926",
      "userAgent": "Mozilla/5.0 (Windows NT 6.2; Win64; x64; rv:21.0.0) Gecko/20121011 Firefox/21.0.0",
      "crypto": {
        "coin": "Bitcoin",
        "wallet": "0xb9fc4b4b855bc44eb30d5e36fd18f491f44a15b7",
        "network": "Ethereum (ERC20)"
      }
    }
  ],
  "total": 10,
  "skip": 0,
  "limit": 3
}
"""

const val PhotosResponse = """
    [
  {
    "albumId": 1,
    "id": 1,
    "title": "accusamus beatae ad facilis cum similique qui sunt",
    "url": "https://via.placeholder.com/600/92c952",
    "thumbnailUrl": "https://via.placeholder.com/150/92c952"
  }
]
"""

val mockEngine = MockEngine { request ->
    when {
        request.url.toString().contains(JsonPlaceHoldersUsersUrl) -> {
            respond(
                status = HttpStatusCode.OK,
                content = JsonPlaceHoldersUsersResponse
            )
        }
        request.url.toString().contains(DummyJsonUsersUrl) -> {
            respond(
                status = HttpStatusCode.OK,
                content = DummyJsonUsersResponse
            )
        }
        request.url.toString().contains("/photos") -> {
            respond(
                status = HttpStatusCode.OK,
                content = PhotosResponse
            )
        }
        else -> respond(
            status = HttpStatusCode.NotFound,
            content = "Invalid Url"
        )
    }
}

val MockKtorClient = HttpClient(

) {

}