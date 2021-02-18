package spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Entityデータベース設定
 */
@RestController
@RequestMapping("")
public class EntityController {
	@Autowired
	protected EntityRepository entityRepo;

	/**
	 * Entityデータベース設定画面
	 */
	@GetMapping("")
	public ModelAndView home(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}

	/**
	 * Entity 入力
	 * <p>
	 * 遷移先 {@link #entityEntry(Entity, ModelAndView) entityEntry}
	 * </p>
	 */
	@GetMapping("entity")
	public ModelAndView employ(@ModelAttribute("entity") Entity entity, ModelAndView mav) {
		mav.setViewName("entity");
		return mav;
	}
	/**
	 * Entity 登録
	 */
	@PostMapping("employ")
	public ModelAndView entityEntry(@ModelAttribute("entity") Entity entity, ModelAndView mav) {
		mav.setViewName("entityEntry");
		entityRepo.save(entity);
		return mav;
	}

	/**
	 * Entity 一覧
	 */
	@GetMapping("entityList")
	public ModelAndView employList(ModelAndView mav) {
		mav.addObject("list", entityRepo.findAll());
		mav.setViewName("entityList");
		return mav;
	}
}
