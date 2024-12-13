function render(onClick) {
    const container = document.querySelector('#container');
    const button = document.createElement('button');
    const div = document.createElement('div');

    div.className = `text-center`;
    button.className = `btn btn-primary`;
    button.type = `button`;
    button.style = `margin-top: 10%; margin-bottom: 10%`;

    div.appendChild(button);

    container.innerHTML = ''; //removes the previous elements
    button.innerText = `CLICK ME FOR RANDOM JOB`;

    button.addEventListener('click', async e => {
        e.preventDefault();

        const {
            title,
            company_name,
            description,
            remote,
            url,
            tags,
            job_types,
            location,
            created_at
        } = await onClick(parseInt(Math.random() * 6));

        const elem = document.createElement('div');
        elem.className = `text-center`;

        elem.innerHTML = `<h1>${title}</h1>
        <h3>${company_name}</h3>
        <h3>${description}</h3>
        <h3>${remote}</h3>
        <h3>${url}</h3>
        <h3>${tags}</h3>
        <h3>${job_types}</h3>
        <h3>${location}</h3>
        <h3>${created_at}</h3>
        `;

        if (container.childElementCount > 1) {
            container.removeChild(container.lastChild);
        }

        container.appendChild(elem);
    });

    container.appendChild(div);
}

export default { render };
