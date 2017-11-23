package com.ikkong.platform.controller;

import java.util.Map;
import com.ikkong.core.base.BaseController;
import com.ikkong.core.jfinal.ext.kit.JsonKit;
import com.ikkong.platform.utils.MyDateUtil;
import com.ikkong.system.controller.base.UrlPermissController;
import com.ikkong.platform.model.Message;
import com.ikkong.platform.service.MessageService;
import com.ikkong.platform.service.impl.MessageServiceImpl;

/**
 * Generated by Blade.
 * 2017-11-22 14:55:28
 */
public class MessageController extends UrlPermissController {
	private static String CODE = "message";
	private static String PERFIX = "message";
	private static String LIST_SOURCE = "Message.list";
	private static String BASE_PATH = "/platform/message/";
	
	MessageService service = new MessageServiceImpl();
	
	public void index() {
		setAttr("code", CODE);
		render(BASE_PATH + "message.html");
	}

	public void add() {
		setAttr("code", CODE);
		render(BASE_PATH + "message_add.html");
	}

	public void edit() {
		String id = getPara(0);
		Message message = service.findById(id);
		setAttr("model", JsonKit.toJson(message));
		setAttr("id", id);
		setAttr("code", CODE);
		render(BASE_PATH + "message_edit.html");
	}

	public void view() {
		String id = getPara(0);
		Message message = service.findById(id);
		setAttr("model", JsonKit.toJson(message));
		setAttr("id", id);
		setAttr("code", CODE);
		render(BASE_PATH + "message_view.html");
	}

	public void list() {
		Object grid = paginate(LIST_SOURCE);
		renderJson(grid);
	}

	public void save() {
		Message message = mapping(PERFIX, Message.class);
		message.setCreate_time(MyDateUtil.getNowDate());
		message.setUpdate_time(MyDateUtil.getNowDate());
		boolean temp = service.save(message);
		if (temp) {
			renderJson(success(SAVE_SUCCESS_MSG));
		} else {
			renderJson(error(SAVE_FAIL_MSG));
		}
	}

	public void update() {
		Message message = mapping(PERFIX, Message.class);
		message.setUpdate_time(MyDateUtil.getNowDate());
//		message.setVersion(message.getVersion()+1);
		boolean temp = service.update(message);
		if (temp) {
			renderJson(success(UPDATE_SUCCESS_MSG));
		} else {
			renderJson(error(UPDATE_FAIL_MSG));
		}
	}

	public void remove() {
		String ids = getPara("ids");
		int cnt = service.deleteByIds(ids);
		if (cnt > 0) {
			renderJson(success(DEL_SUCCESS_MSG));
		} else {
			renderJson(error(DEL_FAIL_MSG));
		}
	}
}
