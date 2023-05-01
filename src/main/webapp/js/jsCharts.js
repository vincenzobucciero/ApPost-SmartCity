var ctx = document.getElementById('myChart').getContext('2d');
var settimane = ['Settimana 1', 'Settimana 2', 'Settimana 3', 'Settimana 4','Settimana 5'];

var st1 = Number( document.getElementById( "prima" ).innerHTML );
var st2 = Number( document.getElementById( "seconda" ).innerHTML );
var st3 = Number( document.getElementById( "terza" ).innerHTML );
var st4 = Number( document.getElementById( "quarta" ).innerHTML );
var st5 = Number( document.getElementById( "quinta" ).innerHTML );

var chart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: settimane,
        datasets: [{
            label: 'Frequency',
            data: [ st1, st2, st3, st4, st5 ],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero:true
                }
            }]
        }
    }
});