// Initialize and add the map
function initMap(): void {
    // The location of naples
    const naples = { lat: 40.8540421, lng: 14.1765619 };
    // The map, centered at naples
    const map = new google.maps.Map(
        document.getElementById("map") as HTMLElement,
        {
            zoom: 10,
            center: naples,
        }
    );

    // The marker, positioned at Uluru
    const marker = new google.maps.Marker({
        position: naples,
        map: map,
    });
}

declare global {
    interface Window {
        initMap: () => void;
    }
}
window.initMap = initMap;