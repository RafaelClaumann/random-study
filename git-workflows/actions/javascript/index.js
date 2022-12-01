const core = require('@actions/core');
const github = require('@actions/github');

try {
    // `name-of-you` input defined in action metadata file
    const yourName = core.getInput('name-of-you');
    console.log(`Hello ${yourName}!`);

    // Get the JSON webhook payload for the event that triggered the workflow
    const payload = JSON.stringify(github.context.payload, undefined, 2)
    console.log(`The event payload: ${payload}`);    

    // set action output `time`
    // accessible through ${{ steps.<step_id>.outputs.time }} inside workflow.yaml
    const time = (new Date()).toTimeString();
    core.setOutput("time", time);

} catch (error) {
    core.setFailed(error.message);
}
