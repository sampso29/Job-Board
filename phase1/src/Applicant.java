import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

public class Applicant extends User {
    private HashMap<String, String> jobsApplied = new HashMap<>();

    String username = this.getUsername();
    Storage st = new Storage();

    public Applicant(String username, String password) {
        super(username, password);

    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public Date getDateCreated() {
        return super.getDateCreated();
    }

    public String getJobs() {

        String s = " ";

        if (!this.jobsApplied.isEmpty()) {
            for (String key : this.jobsApplied.keySet()) {
                s = s + key + "\n";
            }
        } else {
            s = s + "Applicant has not applied for a job";
        }

        return s;
    }

    public void getDocs(String username) {
        st.readFile(username + ".txt");
    }

    public void applyToJob(JobPosting jobPosting) {
        this.jobsApplied.put(jobPosting.getPosition(), "Submitted Resume/CV");
        jobPosting.addApplicant(this);

    }

    public String getJobStatus() {

        String s = "";

        if (!this.jobsApplied.isEmpty()) {
            for (String key : this.jobsApplied.keySet()) {
                s = s + key + ": " + this.jobsApplied.get(key) + "\n";
            }
        } else {
            s = s + "Applicant has not applied for a job";
        }

        return s;

    }

    public void updateStatus(JobPosting job, String status) {

        this.jobsApplied.put(job.getPosition(), status);
    }

    public void getHistory() {
    }

    public String getInfo(){
        return "Applicant Username: " + username + '\n' +
                "\n Date Created: " + this.getDateCreated() + "\n" +
                "\nJobs Applied To:\n" + this.getJobs();
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "jobsApplied=" + jobsApplied +
                ", username='" + username + '\'' +
                ", st=" + st +
                '}';
    }
}
