function render(onClick) {
    const container = document.querySelector('#container');

    const button = document.createElement('button');
    const div = document.createElement('div');

    div.className = `text-center`;
    div.id ="aaa";
    button.className = `btn btn-primary`;
    button.type = `button`;
    button.style = `margin-top: 10%; margin-bottom: 10%`;

    div.appendChild(button);

    container.innerHTML = ''; //removes the previous elements
    button.innerText = `CLICK ME FOR RANDOM CHARACTER`;

    button.addEventListener('click', async e => {
        e.preventDefault();

        const {
            id,
            name,
            image,
        } = await onClick(parseInt(Math.random() * 6));

        const elem = document.createElement('div');
        elem.className = `text-center`;

        elem.innerHTML = `
        <h1 >${id}</h1>
        <h3>${name}</h3>
        <h3>${image}</h3>
        `;

        if (container.childElementCount > 1) {
            container.removeChild(container.lastChild);
        }

        container.appendChild(elem);
    });

    container.appendChild(div);
}

export default { render };
