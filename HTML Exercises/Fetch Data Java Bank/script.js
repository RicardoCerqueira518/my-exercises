async function getCustomers(url) {
    try {
        const response = await fetch(url);
        const body = await response.json();
        if (!response.ok) {
            throw new Error(body.message);
        }
        const table = document.getElementById("tableBody");
        table.innerHTML = "";
        body.forEach((customer) => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
                <td>${customer.phone}</td>
                <td><button onclick="editCustomer(${customer.id})">Edit</button></td>
                <td><button onclick="deleteCustomer(${customer.id})">Delete</button></td>
            `;
            table.appendChild(row);
        });
    } catch (error) {
        console.error("Error fetching customers:", error);
    }
}
async function addCustomer() {
    const customer = {
        firstName: document.getElementById("firstName").value,
        lastName: document.getElementById("lastName").value,
        email: document.getElementById("email").value,
        phone: document.getElementById("phoneNumber").value,
    };

    try {
        const response = await fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(customer),
        });
        if (!response.ok) {
            const errorBody = await response.json();
            throw new Error(errorBody.message || "Failed to add customer");
        }
        // Fetch the updated list after adding a customer
        await getCustomers(url);
    } catch (error) {
        console.error("Error adding customer", error);
    }
}

async function updateCustomer() {
    const customer = {
        firstName: document.getElementById("firstName").value,
        lastName: document.getElementById("lastName").value,
        email: document.getElementById("email").value,
        phone: document.getElementById("phoneNumber").value,
    };

    try {
        const response = await fetch(url, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(customer),
        });
        if (!response.ok) {
            const errorBody = await response.json();
            throw new Error(errorBody.message || "Failed to update customer");
        }
        // Fetch the updated list after updating a customer
        await getCustomers(url);
    } catch (error) {
        console.error("Error updating customer", error);
    }
}

async function reset() {
    const form = document.getElementById("form");
    form.reset();
}
const url = "http://localhost:8080/javabank5/api/customer";

async function deleteCustomer(customerId) {
    try {
        const response = await fetch(`${url}/${customerId}`, {
            method: "DELETE",
        });
        if (!response.ok) {
            const errorBody = await response.json();
            throw new Error(errorBody.message || "Failed to delete customer");
        }
        // Refresh the customer list after successful deletion
        await getCustomers(url);
    } catch (error) {
        console.log("Error deleting customer:", error);
    }
}

async function editCustomer(customerId) {
    try {
        const response = await fetch(`${url}/${customerId}`, {
            method: "PUT",
        });
        if (!response.ok) {
            const errorBody = await response.json();
            throw new Error(errorBody.message || "Failed to edit customer");
        }
        // Fetch the updated list after editing a customer
        await getCustomers(url);

    } catch (error) {
        console.error("Error editing customer:", error);
    }
}


// Fetch the initial list of customers
getCustomers(url);

// Attach event listener
document.getElementById("add").addEventListener("click", addCustomer);
document.getElementById("reset").addEventListener("click", reset);
document.getElementById("update").addEventListener("click", updateCustomer);