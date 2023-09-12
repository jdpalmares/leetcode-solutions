import java.util.ArrayList;
import java.util.Stack;

public class SimplifyPath {
    // easiest to understand solution
    public String simplifyPath(String path) {
        Stack<String> canonPath = new Stack<String>();
        String[] dirs = path.split("/");
        for (int i = 0; i < dirs.length; i++) {
            if (!canonPath.empty() && dirs[i].equals(".."))
                canonPath.pop();
            else if (!dirs[i].equals(".") &&
                    !dirs[i].equals("") &&
                    !dirs[i].equals(".."))
                canonPath.push(dirs[i]);
        }
        return "/" + String.join("/", new ArrayList<String>(canonPath));
    }
}
