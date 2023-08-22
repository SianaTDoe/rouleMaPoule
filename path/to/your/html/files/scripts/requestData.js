const  API_URL = "http://localhost:8080/api/";

async function bookingRideForUser(data) {

    let conf = {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: null
    }

    let booking = {
        trajetID: data.rideId,
        dateReservation: "07-06-2023",
        nbDePlace: 1,
        utilisateurID: users[1].id
    }

    conf.body = JSON.stringify(booking)

    let query = fetch(`${API_URL}reservation/addReservation`, conf)
    query.then(response => {
        console.log(response)
    }).catch(error => {
        console.log("error", error)
    })
}
async function requestUsers() {
    let query = await fetch(`${API_URL}user/all`)
    if (query.ok === true) {
        return query.json()
    }
    throw new Error("Une erreur est survenue")
}
async function getRides() {
    const query = await fetch(`${API_URL}trajet/all`)
    if(query.ok === true){
        return query.json()
    }
    throw new Error("Une erreur est survenue")
}
async function requestRidesFromCities(startCity, endCity){
    let start = `villeDepart=${startCity}`
    let end = `villeArrivee=${endCity}`

    const query = await fetch(`${API_URL}trajet/rechercheVilleDepartEtArrivee?${start}&${end}`)
    if(query.ok === true){
        return query.json()
    }
    throw new Error("Une erreur est survenue")


}
function insertRide(data){

    let conf = {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: null
    }
    conf.body = JSON.stringify(data)
    let query = fetch(`${API_URL}trajet/addTrajet`, conf)
    query.then(response => {
        console.log(response)
    })

}



function insertFakeData(){

    let cities = [
        "Lyon",
        "Paris",
        "Lille",
        "Toulouse",
        "Porto-Vecchio",
    ]
    let dates = [
        "08-06-2023",
        "09-06-2023",
        "10-06-2023",
    ]
    let hours = [
        "6:00",
        "9:00",
        "10:30",
        "12:00",
        "14:30",
        "17:30",
        "18:00",
        "20:00",
    ]
    let prices = [
        25, 30, 40, 50, 75, 100,
    ]

    let defaultRide = {
        villeDepart: null,
        villeArrivee: null,
        date: null,
        heureDepart: null,
        description: "Trajet de test",
        places: 4,
        prix: null,
        complet: false,
        conducteurID: users[Math.floor(Math.random() * users.length )].id,
    }

    dates.forEach(date => {
        cities.forEach(city => {
            cities.forEach(town => {
                if(town !== city){
                    let ride = defaultRide
                    ride.villeDepart = city
                    ride.villeArrivee = town
                    ride.date = date
                    ride.prix = prices[Math.floor(Math.random()* prices.length)]
                    ride.heureDepart = hours[Math.floor(Math.random() *  hours.length)]
                    insertRide(ride)
                }
            })
        })
    })
}

async function insertFakeUsers(){

    let users = [
        {
            lastname: "ChickenRun",
            firstname: "Ginger",
            email: "ginger@cocote.com"
        },
        {
            lastname: "ChickenRun",
            firstname: "Bucky",
            email: "bucky@cocorico.com"
        },
        {
            lastname: "Estelle",
            firstname: "Depoulet",
            email: "estelle@depoulet.com"
        },
        {
            lastname: "Cluck",
            firstname: "Buck",
            email: "buck@cluck.com"
        },
    ]

    let conf = {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: null
    }

    let response = []
    for (const user of users) {
        conf.body = JSON.stringify(user)
        let query = await fetch(`${API_URL}user/addUser`, conf)
        if(query.ok === true){
            response.push(query)
        } else {
            throw new Error("Une erreur est survenue")
        }
    }
    return response

}


