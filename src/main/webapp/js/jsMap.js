// Initialize and add the map
function initMap() {

    //Posizione di Napoli
    const naples = { lat: 40.8518, lng: 14.2681 };

    //La mappa deve essere centrata a napoli
    const map = new google.maps.Map(document.getElementById("map"), {
        zoom: 15,
        center: naples,
    });

    // Il marker su Napoli
    const marker = new google.maps.Marker({
        position: naples,
        map: map,
    });

    //I miei parcheggi
    //Vado a inserire le cordinate dei miei parcheggi e le dichiaro costanti:
    const park1 = {lat: 40.836633, lng: 14.250964}; //Via Toledo:
    const park2 = {lat: 40.851236, lng: 14.258433}; //Via dei Tribunali
    const park3 = {lat: 40.851867, lng: 14.255105}; //Via San Gregorio Armeno
    const park4 = {lat: 40.822874, lng: 14.241816}; //Via Caracciolo
    const park5 = {lat: 40.835205, lng: 14.242934}; //Via Chiaia
    const park6 = {lat: 40.831728, lng: 14.245899}; //Via Partenope

    //Aggiungo i marker:
    const marker1 = new google.maps.Marker({
        position: park1,
        map: map,
    });

    const marker2 = new google.maps.Marker({
        position: park2,
        map: map,
    });

    const marker3 = new google.maps.Marker({
        position: park3,
        map: map,
    });

    const marker4 = new google.maps.Marker({
        position: park4,
        map: map,
    });

    const marker5 = new google.maps.Marker({
        position: park5,
        map: map,
    });

    const marker6 = new google.maps.Marker({
        position: park6,
        map: map,
    });


    //Per la descrizione del Marker (ogni parcheggio)
    const infowindow1 = new google.maps.InfoWindow({
        content: "Parcheggio di Via Toledo",
    });

    marker1.addListener("click", () => {
        infowindow1.open(map, marker1);
    });

    //Prova secondo parcheggio
    const infowindow2 = new google.maps.InfoWindow({
        content: "Via dei Tribunali",
    });

    marker2.addListener("click", () => {
        infowindow2.open(map, marker2);
    });

}

window.initMap = initMap;
