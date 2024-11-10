const donors = [];
const hospitals = [];
const bloodDrives = [];

function openTab(tabName) {
    const tabs = document.getElementsByClassName('tab-content');
    for (let tab of tabs) {
        tab.style.display = 'none';
    }
    document.getElementById(tabName).style.display = 'block';
}

function registerDonor() {
    const name = document.getElementById('donorName').value;
    const bloodType = document.getElementById('donorBloodType').value;
    const location = document.getElementById('donorLocation').value;

    if (name && bloodType && location) {
        donors.push({ name, bloodType, location });
        document.getElementById('donorMessage').innerText = "Donor registered successfully!";
        updateDonorList();
        clearFields(['donorName', 'donorBloodType', 'donorLocation']);
    } else {
        alert("Please fill all fields!");
    }
}

function registerHospital() {
    const name = document.getElementById('hospitalName').value;
    const location = document.getElementById('hospitalLocation').value;

    if (name && location) {
        hospitals.push({ name, location });
        document.getElementById('hospitalMessage').innerText = "Hospital registered successfully!";
        updateHospitalList();
        clearFields(['hospitalName', 'hospitalLocation']);
    } else {
        alert("Please fill all fields!");
    }
}

function addBloodDrive() {
    const location = document.getElementById('bloodDriveLocation').value;
    const date = document.getElementById('bloodDriveDate').value;

    if (location && date) {
        bloodDrives.push({ location, date });
        document.getElementById('bloodDriveMessage').innerText = "Blood drive added successfully!";
        updateBloodDriveList();
        clearFields(['bloodDriveLocation', 'bloodDriveDate']);
    } else {
        alert("Please fill all fields!");
    }
}

function clearFields(fieldIds) {
    fieldIds.forEach(id => document.getElementById(id).value = '');
}

function updateDonorList() {
    const list = document.getElementById('donorList');
    list.innerHTML = '';
    donors.forEach((donor, index) => {
        const li = document.createElement('li');
        li.innerHTML = `
            ${donor.name} - ${donor.bloodType}, ${donor.location}
            <div>
                <button onclick="editDonor(${index})">Edit</button>
                <button onclick="deleteDonor(${index})">Delete</button>
            </div>
        `;
        list.appendChild(li);
    });
}

function updateHospitalList() {
    const list = document.getElementById('hospitalList');
    list.innerHTML = '';
    hospitals.forEach((hospital, index) => {
        const li = document.createElement('li');
        li.innerHTML = `
            ${hospital.name}, ${hospital.location}
            <div>
                <button onclick="editHospital(${index})">Edit</button>
                <button onclick="deleteHospital(${index})">Delete</button>
            </div>
        `;
        list.appendChild(li);
    });
}

function updateBloodDriveList() {
    const list = document.getElementById('bloodDriveList');
    list.innerHTML = '';
    bloodDrives.forEach((bloodDrive, index) => {
        const li = document.createElement('li');
        li.innerHTML = `
            ${bloodDrive.location} on ${bloodDrive.date}
            <div>
                <button onclick="editBloodDrive(${index})">Edit</button>
                <button onclick="deleteBloodDrive(${index})">Delete</button>
            </div>
        `;
        list.appendChild(li);
    });
}

function searchDonors() {
    const query = document.getElementById('donorSearch').value.toLowerCase();
    const filteredDonors = donors.filter(donor =>
        donor.name.toLowerCase().includes(query) ||
        donor.bloodType.toLowerCase().includes(query) ||
        donor.location.toLowerCase().includes(query)
    );
    renderDonorList(filteredDonors);
}

function searchHospitals() {
    const query = document.getElementById('hospitalSearch').value.toLowerCase();
    const filteredHospitals = hospitals.filter(hospital =>
        hospital.name.toLowerCase().includes(query) ||
        hospital.location.toLowerCase().includes(query)
    );
    renderHospitalList(filteredHospitals);
}

function searchBloodDrives() {
    const query = document.getElementById('bloodDriveSearch').value.toLowerCase();
    const filteredBloodDrives = bloodDrives.filter(bloodDrive =>
        bloodDrive.location.toLowerCase().includes(query) ||
        bloodDrive.date.toLowerCase().includes(query)
    );
    renderBloodDriveList(filteredBloodDrives);
}

function renderDonorList(donorList) {
    const list = document.getElementById('donorList');
    list.innerHTML = '';
    donorList.forEach((donor, index) => {
        const li = document.createElement('li');
        li.innerHTML = `
            ${donor.name} - ${donor.bloodType}, ${donor.location}
            <div>
                <button onclick="editDonor(${index})">Edit</button>
                <button onclick="deleteDonor(${index})">Delete</button>
            </div>
        `;
        list.appendChild(li);
    });
}

function renderHospitalList(hospitalList) {
    const list = document.getElementById('hospitalList');
    list.innerHTML = '';
    hospitalList.forEach((hospital, index) => {
        const li = document.createElement('li');
        li.innerHTML = `
            ${hospital.name}, ${hospital.location}
            <div>
                <button onclick="editHospital(${index})">Edit</button>
                <button onclick="deleteHospital(${index})">Delete</button>
            </div>
        `;
        list.appendChild(li);
    });
}

function renderBloodDriveList(bloodDriveList) {
    const list = document.getElementById('bloodDriveList');
    list.innerHTML = '';
    bloodDriveList.forEach((bloodDrive, index) => {
        const li = document.createElement('li');
        li.innerHTML = `
            ${bloodDrive.location} on ${bloodDrive.date}
            <div>
                <button onclick="editBloodDrive(${index})">Edit</button>
                <button onclick="deleteBloodDrive(${index})">Delete</button>
            </div>
        `;
        list.appendChild(li);
    });
}

function editDonor(index) {
    const donor = donors[index];
    document.getElementById('donorName').value = donor.name;
    document.getElementById('donorBloodType').value = donor.bloodType;
    document.getElementById('donorLocation').value = donor.location;
    donors.splice(index, 1);
    updateDonorList();
    openTab('donor');
}

function editHospital(index) {
    const hospital = hospitals[index];
    document.getElementById('hospitalName').value = hospital.name;
    document.getElementById('hospitalLocation').value = hospital.location;
    hospitals.splice(index, 1);
    updateHospitalList();
    openTab('hospital');
}

function editBloodDrive(index) {
    const bloodDrive = bloodDrives[index];
    document.getElementById('bloodDriveLocation').value = bloodDrive.location;
    document.getElementById('bloodDriveDate').value = bloodDrive.date;
    bloodDrives.splice(index, 1);
    updateBloodDriveList();
    openTab('bloodDrive');
}

function deleteDonor(index) {
    donors.splice(index, 1);
    updateDonorList();
}

function deleteHospital(index) {
    hospitals.splice(index, 1);
    updateHospitalList();
}

function deleteBloodDrive(index) {
    bloodDrives.splice(index, 1);
    updateBloodDriveList();
}

// Initialize with the donor tab open
openTab('donor');