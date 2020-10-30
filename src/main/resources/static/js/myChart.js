var chartDataStr = decodeHTML(chartData);
var chartJsonArray = JSON.parse(chartDataStr);

var arrayLength = chartJsonArray.length;

var numericData =[];
var labelData = [];

for(var i = 0; i < arrayLength; i++) {
	numericData[i] = chartJsonArray[i].value;
	labelData[i] = chartJsonArray[i].label;
}


// For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
     data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#1795e3","#e33217", "#d3d624"],
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
    	title: {
    		display: true,
    		text: 'Project Status'
    	}
    }
});

function decodeHTML(html) {
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}