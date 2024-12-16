function render(characters) {
    const container = document.querySelector('#container');
    container.innerHTML = '<br>'; //removes the previous elements
    const list = document.createElement('div');
    list.style = `display: flex; margin-top: 10%`;
    list.className = `text-center`;

    characters.forEach(({id, name, images}, i) => {
        const item = document.createElement('div');
        item.className = `col card text-white bg-primary mb-3" style="max-width: 18rem;`;
        item.innerHTML = `<div class="card-header">${id}</div>
                            <div class="card-body">
                                <h5 class="name">${name}</h5>
                            <div class="card-text">
                                    <img src="${images}"/>
                            </div>
                        </div>`;
        list.appendChild(item);
    });

    container.appendChild(list);
}

export default { render };