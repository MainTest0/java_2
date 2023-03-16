package url_db_test.controller;

import url_db_test.service.UrlService;

public class UrlController {

	private UrlService urlService;

	public UrlController() {
		urlService = new UrlService();
	}

	public String save(int userId, int id,  String title) {

			String response = urlService.save(id, userId, title);

		return response;
	}
}
