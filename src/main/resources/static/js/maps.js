let map;

function initMap() {
  map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: 36.965, lng: -119.755 },
    zoom: 7,
  });
}