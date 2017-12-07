
public class ActionItem {
	private Integer actionID;
	private Object component;
	public ActionItem(Integer id, Object object) {
		actionID=id;
		component=object;
	}
	public Integer getID() {
		return actionID;
	}
	public Object getComponent() {
		return component;
	}
	public boolean same(ActionItem compareTo) {
		if(this.actionID==compareTo.actionID && this.component==compareTo.component) {
			return true;
		}else {
			return false;
		}
	}
}
