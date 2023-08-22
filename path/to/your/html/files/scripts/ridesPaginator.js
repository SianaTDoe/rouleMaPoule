function setRides(){
    let parts = selectRidesInRange(currentIndex)
    console.log(parts)
    document.getElementById("rides-container").innerHTML = ""
    parts.forEach(ride => {
        document.getElementById("rides-container").appendChild(generateRideCardElement(ride))
    })
    setPaginationData()
}

function nextRides(){
    if(currentIndex < maxRides){
        currentIndex++
        setRides()
    }
    togglePaginationBtn()
}

function previousRides(){
    if(currentIndex > 1){
        currentIndex--
        setRides()
    }
    togglePaginationBtn()
}

function togglePaginationBtn(){

    let previousBtn = document.querySelectorAll("#pagination_container button")[0]
    let nextBtn = document.querySelectorAll("#pagination_container button")[1]
    let className = "hidden"

    if(currentIndex === 1){
        previousBtn.classList.add(className)
        if(maxRides === 1){
            //nextBtn.classList.add(className)
        }
    } else if(currentIndex === maxRides){
        nextBtn.classList.add(className)
        if(previousBtn.classList.contains(className)){
            previousBtn.classList.remove(className)
        }
    } else if(currentIndex < maxRides && nextBtn.classList.contains(className)){
        nextBtn.classList.remove(className)
    } else if(currentIndex > 1 && previousBtn.classList.contains(className)){
        previousBtn.classList.remove(className)
    }
}

function setPaginationData(){
    document.getElementById("indicator").innerText = `${currentIndex}-${maxRides}`
}

function selectRidesInRange(index){
    return rides.slice(((index - 1) * maxItems), (index * maxItems))
}

function generateRideCardElement(ride){

    let cardElement = document.createElement("div")
    cardElement.classList.add("result-card")

    let infoElement = document.createElement("div")
    infoElement.classList.add("info")

    let rideElement = document.createElement("h2")
    rideElement.innerText = `${ride.villeDepart} - ${ride.villeArrivee}`

    let priceElement = document.createElement("p")
    priceElement.innerText = `Prix : ${ride.prix}€`

    let seatElement = document.createElement("p")
    seatElement.innerText = `Places restantes : ${ride.places}`

    let dateElement = document.createElement("p")
    dateElement.innerText = `Date : ${ride.date} à ${ride.heureDepart}`

    let actionElement = document.createElement("div")
    actionElement.classList.add("action")
/*
    let buttonElement = document.createElement("button")
    buttonElement.innerText = "voir le détail du trajet"
    buttonElement.id = "btnDetail"
*/
    let bookingBtn = document.createElement("button")
    bookingBtn.innerText = "Réserver une place"
    bookingBtn.addEventListener("click", function () {bookingARide(ride.id)})


    //actionElement.appendChild(buttonElement)
    actionElement.appendChild(bookingBtn)

    infoElement.appendChild(rideElement)
    infoElement.appendChild(priceElement)
    infoElement.appendChild(seatElement)
    infoElement.appendChild(dateElement)

    cardElement.appendChild(infoElement)
    cardElement.appendChild(actionElement)

    return cardElement;

}
