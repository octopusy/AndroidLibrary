package library.demo.logic;

import library.demo.R;
import library.demo.api.ModuleAApi;
import library.demo.base.DemoBaseLogic;


/**
 * @author zhuhf
 * @version [AndroidLibrary, 2018-03-07]
 */
public class ModuleALogic extends DemoBaseLogic {
    ModuleAApi api;
    /**
     * 构造函数
     *
     * @param subscriber 最终订阅者
     */
    public ModuleALogic(Object subscriber) {
        super(subscriber);
        api = create(ModuleAApi.class);
    }
    
    public void categoryList() {
        sendRequest(api.categoryList(), R.id.demo_id);
    }
}
