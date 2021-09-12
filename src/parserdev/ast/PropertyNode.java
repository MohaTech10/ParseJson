package parserdev.ast;

// We need Creator SubSystem for example data structure for classCreator(objectName) then classCreator.instance.push(eachElem);? may be but i will try to gather as much info as i can
// in subsystem component;
public class PropertyNode {

    /*ValueNode parent?*/

    public String key;
    public ValueNode value;

    public PropertyNode(String key, ValueNode value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "PropertyNode{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
