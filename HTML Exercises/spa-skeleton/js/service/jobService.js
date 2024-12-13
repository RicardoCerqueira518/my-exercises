const url = "https://arbeitnow.com/api/job-board-api";

async function getJob(url) {
    return url;
}

async function getJobs() {
    try {
        const response = await fetch(url);
        if (!response.ok) throw new Error("Falha ao buscar jobs");

        const jobs = await response.json();
        

    } catch (error) {
        handleError(error.message);
    }
}


export default { getJob, getJobs };