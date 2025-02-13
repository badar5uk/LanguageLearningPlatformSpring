const tutorLinkList = [];
const videoNameList = [];

 async function getLinks() {
    let response = await fetch("http://localhost:8080/tutor/getTutorVideos?tutorId=53").
    then((result) => result.json()).
    then((tutor) => tutor.tutorVideo);
    response.forEach(element => {
        tutorLinkList.push(element.link)
    });
    return response;
}
 async function fetchVideoNames() {
    let response = await fetch("http://localhost:8080/tutor/getTutorVideos?tutorId=53").
    then((result) => result.json()).
    then((tutor) => tutor.tutorVideo);
    response.forEach(element => {
        videoNameList.push(element.title)
    });
    return response;
}


//const btn = document.createElement("button");
//btn.innerHTML = '<iframe width="560" height="315" src="'.stripslashes($row['videourl']).'" frameborder="0" allowfullscreen></iframe>';

//btn.innerHTML = '<img src="http://img.youtube.com/ZMpekpfglxA?si=BqzAABfDOoKD5jSW.jpg" title="YouTube Video" alt="YouTube Video" />'
//document.body.appendChild(btn);

async function buildTable() {

await getLinks();
await fetchVideoNames();
    
const table = document.createElement('table');
table.style.border = '1px solid black';

// Create a header row for the table
const headerRow = document.createElement('tr');

const headerCell1 = document.createElement('th');
headerCell1.textContent = 'video Link';
headerRow.appendChild(headerCell1);

const headerCell2 = document.createElement('th');
headerCell2.textContent = 'Name';
headerRow.appendChild(headerCell2);

// Append the header row to the table
table.appendChild(headerRow);

console.log("List :".concat(tutorLinkList));

// Loop through the arrays to create table rows
for (let i = 0; i < tutorLinkList.length; i++) {
    const row = document.createElement('tr');
  const cell1 = document.createElement('td');

  // Create the cell for the Arabic link

//   const link = document.createElement('button');
//   link.href = arabicLinkList[i];
//   link.textContent = arabicLinkList[i];
//   //cell1.src = link;
//   link.target = "_blank";
//   cell1.appendChild(link);
//   row.appendChild(cell1);

const button = document.createElement('iframe');
button.src = tutorLinkList[i]; 

button.onclick = function() {
  window.open(emmaLinkList[i], "_blank");
};
cell1.appendChild(button);
row.appendChild(cell1);

  // Create the cell for the Name
  const cell2 = document.createElement('td');
  cell2.textContent = videoNameList[i];
  row.appendChild(cell2);

  // Append the row to the table
  table.appendChild(row);
}

// Append the table to the body of the HTML document
document.body.appendChild(table);
 }

 buildTable();