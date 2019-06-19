import java.util.LinkedList;
import java.util.Queue;


public class PartBSolution {

    private static Queue<SiteStats> sites = new LinkedList<SiteStats>();

    //  method to list top n visited sites
    public static void listTopVisitedSites(Queue<SiteStats> sites, int n) {
        // WRITE CODE HERE
        // Sort the queue based on the number of times it was visited.
        sortTheHistory(sites);
        for (int i = 0; i < n; i++) {
            System.out.println(sites.poll());
        }
    }

    public static void sortTheHistory(Queue<SiteStats> sites) {
        int historySize = sites.size();
        for (int i = 1; i <= historySize; i++) {
            // we are adding the most visited site to the queue and start finding the nxt mostvisited by exclusing the last one
            int index_min = FindTheMostVisitedIndex(sites, historySize - i);
            // we are adding the index at which we have mostvisited site to the queue at rear
            insertMinToRear(sites, index_min);
        }
    }
// the below method is implemented to find the index which is most visited
    public static int FindTheMostVisitedIndex(Queue<SiteStats> sites, int sort_index) {
        int min_index = -1;
        int mostVisited = Integer.MIN_VALUE;
        int historySize = sites.size();
        for (int i = 0; i < historySize; i++) {
            SiteStats temp = sites.peek();
            int current = temp.getNumVisits();
            if (current > mostVisited && i <= sort_index) {
                min_index = i;
                mostVisited = current;
            }
            sites.add(sites.poll());
        }
        return min_index;
    }
// here we are adding the most visited site to rear, this brings the mosted visted site the first to be polled
    public static void insertMinToRear(Queue<SiteStats> sites, int min_index) {
        SiteStats leastVisited = null;
        int historySize = sites.size();
        for (int i = 0; i < historySize; i++) {
            SiteStats temp = sites.peek();
            sites.poll();
            if (i != min_index)
                sites.add(temp);
            else
                leastVisited = temp;
        }
        sites.add(leastVisited);
    }
    // Method to find the website in the queue and increment the visited count by 1, adding new node in case website is not found
    public static void updateCount(String url) {
        // WRITE CODE HERE
        int count = 0;
        if (sites.isEmpty()) {
            sites.add(new SiteStats(url, 1));
        } else {
            int historySize = sites.size();
            for (int i = 0; i < historySize; i++) {

                String tempUrl = sites.peek().getUrl();
                int tempCount = sites.peek().getNumVisits();

                if (url.equalsIgnoreCase(tempUrl)) {
                    count++; // we are keeping track of the urls which have already been visited
                    sites.peek().setNumVisits(tempCount + 1);
                }
                sites.add(sites.poll());
            }
            if (count == 0) {
                sites.add(new SiteStats(url, 1));
            } else
                return;
        }
    }

    public static void main(String[] args) {
        String[] visitedSites = {"www.google.co.in", "www.google.co.in", "www.facebook.com", "www.upgrad.com", "www.google.co.in", "www.youtube.com",
                "www.facebook.com", "www.upgrad.com", "www.facebook.com", "www.google.co.in", "www.microsoft.com", "www.9gag.com", "www.netflix.com",
                "www.netflix.com", "www.9gag.com", "www.microsoft.com", "www.amazon.com", "www.amazon.com", "www.uber.com", "www.amazon.com",
                "www.microsoft.com", "www.upgrad.com"};

        for (String url : visitedSites) {
            updateCount(url);
        }
        listTopVisitedSites(sites, 5);
    }
}
