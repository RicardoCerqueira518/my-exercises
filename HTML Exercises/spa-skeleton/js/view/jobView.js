function render(jobs) {
    const container = document.querySelector('#container');
    container.innerHTML = '<br>'; //removes the previous elements
    const list = document.createElement('div');
    list.style = `display: flex; margin-top: 10%`;
    list.className = `text-center`;

    console.log(jobs);

    jobs.forEach((job) => {
        const item = document.createElement('div');
        item.className = `col card text-white bg-primary mb-3" style="max-width: 18rem;`;
        item.innerHTML = `<div class="card-header">${job.description}</div>
                            <div class="card-body">
                                <h5 class="card-title">${job.title}</h5>
                                <p class="card-text">
                                    <p>company_name: ${job.company_name}</p>
                                    <p>description: ${job.description}</p>
                                    <p>remote: ${job.remote}</p>
                                    <p>url: ${job.url}</p>
                                    <p>tags: ${job.tags}</p>
                                    <p>job_types: ${job.job_types}</p>
                                    <p>location: ${job.location}</p>
                                    <p>created_at: ${job.created_at}</p>
                                </p>
                        </div>`;
        list.appendChild(item);
    });

    container.appendChild(list);
}

export default { render };