import jobService from '../service/jobService.js';
import jobView from '../view/jobView.js';

export async function init() {
    const jobs = await jobService.getJobs();
    jobView.render(jobs);
}
