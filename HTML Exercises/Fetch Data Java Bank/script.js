const url = "http://localhost:8080/javabank5/api/customer";

// Função auxiliar para tratar erros
function handleError(message) {
    console.error(message);
    alert(message);
}

// Valida os campos do formulário
function validateForm() {
    const firstName = document.getElementById("firstName").value.trim();
    const lastName = document.getElementById("lastName").value.trim();
    const email = document.getElementById("email").value.trim();
    const phone = document.getElementById("phoneNumber").value.trim();

    if (!firstName || !lastName || !email || !phone) {
        throw new Error("Todos os campos são obrigatórios!");
    }

    if (!/\S+@\S+\.\S+/.test(email)) {
        throw new Error("E-mail inválido!");
    }

    if (!/^\d+$/.test(phone)) {
        throw new Error("Número de telefone inválido! Apenas dígitos são permitidos.");
    }

    return { firstName, lastName, email, phone };
}

// Atualiza a lista de clientes na tabela
async function getCustomers() {
    try {
        const response = await fetch(url);
        if (!response.ok) throw new Error("Falha ao buscar clientes");

        const customers = await response.json();
        const table = document.getElementById("tableBody");
        table.innerHTML = "";

        customers.forEach((customer) => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
                <td>${customer.phone}</td>
                <td><button onclick="editCustomer(${customer.id})">Editar</button></td>
                <td><button onclick="deleteCustomer(${customer.id})">Apagar</button></td>
            `;
            table.appendChild(row);
        });
    } catch (error) {
        handleError(error.message);
    }
}

// Adiciona um novo cliente
async function addCustomer() {
    try {
        const customer = validateForm();

        const response = await fetch(url, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(customer),
        });

        if (!response.ok) {
            const errorBody = await response.json();
            throw new Error(errorBody.message || "Falha ao adicionar cliente");
        }

        alert("Cliente adicionado com sucesso!");
        await getCustomers();
        reset();
    } catch (error) {
        handleError(error.message);
    }
}

// Atualiza os dados de um cliente
async function updateCustomer() {
    const customerId = document.getElementById("customerId").value;
    if (!customerId) {
        handleError("Nenhum cliente selecionado para atualizar.");
        return;
    }

    try {
        const customer = validateForm();

        const response = await fetch(`${url}/${customerId}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(customer),
        });

        if (!response.ok) {
            const errorBody = await response.json();
            throw new Error(errorBody.message || "Falha ao atualizar cliente");
        }

        alert("Cliente atualizado com sucesso!");
        await getCustomers();
        reset();
    } catch (error) {
        handleError(error.message);
    }
}

// Limpa o formulário
function reset() {
    document.getElementById("form").reset();
    document.getElementById("customerId").value = "";
}

// Apaga um cliente
async function deleteCustomer(customerId) {
    if (!confirm("Tem certeza de que deseja apagar este cliente?")) return;

    try {
        const response = await fetch(`${url}/${customerId}`, {
            method: "DELETE",
        });

        if (!response.ok) {
            const errorBody = await response.json();
            throw new Error(errorBody.message || "Falha ao apagar cliente");
        }

        alert("Cliente apagado com sucesso!");
        await getCustomers();
    } catch (error) {
        handleError(error.message);
    }
}

// Carrega os dados de um cliente para edição
async function editCustomer(customerId) {
    try {
        const response = await fetch(`${url}/${customerId}`);
        if (!response.ok) throw new Error("Falha ao buscar os detalhes do cliente");

        const customer = await response.json();
        document.getElementById("customerId").value = customerId;
        document.getElementById("firstName").value = customer.firstName;
        document.getElementById("lastName").value = customer.lastName;
        document.getElementById("email").value = customer.email;
        document.getElementById("phoneNumber").value = customer.phone;
    } catch (error) {
        handleError(error.message);
    }
}

// Event listeners
document.getElementById("add").addEventListener("click", addCustomer);
document.getElementById("reset").addEventListener("click", reset);
document.getElementById("update").addEventListener("click", updateCustomer);

// Carrega a lista inicial de clientes
getCustomers();
