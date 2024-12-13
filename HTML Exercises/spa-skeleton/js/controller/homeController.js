import homeView from '../view/homeView.js';
import jobService from '../service/jobService.js';

export function init() {
    homeView.render(jobService.getJob);
}
