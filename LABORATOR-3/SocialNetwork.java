import java.util.*;

public class SocialNetwork {
    private List<Profile> nodes = new ArrayList<>();

    public void addProfile(Profile p) {
        if (!nodes.contains(p)) nodes.add(p);
    }

    public int getImportance(Profile p) {
        if (p instanceof Person) {
            return ((Person) p).getRelationships().size();
        } else if (p instanceof Company) {
            return ((Company) p).getEmployeeCount();
        }
        return 0;
    }

    public void printNetwork() {
        nodes.sort((p1, p2) -> Integer.compare(getImportance(p2), getImportance(p1)));
        for (Profile p : nodes) {
            System.out.println(p + " , Importanta: " + getImportance(p));
        }
    }

    public void findCriticalNodes() {

        for (Profile p : nodes) {
            if (isArticulationPoint(p)) {
                System.out.println("adv:  " + p.getName() + " mentine reteaua conectata.");
            }
        }
    }

    private boolean isArticulationPoint(Profile removed) {
        if (nodes.size() < 3) return false;
        Profile start = null;
        for (Profile n : nodes) {
            if (!n.equals(removed)) { start = n; break; }
        }
        Set<Profile> visited = new HashSet<>();
        dfs(start, removed, visited);
        return visited.size() < (nodes.size() - 1);
    }

    private void dfs(Profile curr, Profile skip, Set<Profile> visited) {
        visited.add(curr);
        for (Profile next : getNeighbors(curr)) {
            if (!next.equals(skip) && !visited.contains(next)) {
                dfs(next, skip, visited);
            }
        }
    }

    private List<Profile> getNeighbors(Profile p) {
        List<Profile> neighbors = new ArrayList<>();
        if (p instanceof Person) {
            neighbors.addAll(((Person) p).getRelationships().keySet());
        }
        for (Profile other : nodes) {
            if (other instanceof Person && ((Person) other).getRelationships().containsKey(p)) {
                if (!neighbors.contains(other)) neighbors.add(other);
            }
        }
        return neighbors;
    }
}