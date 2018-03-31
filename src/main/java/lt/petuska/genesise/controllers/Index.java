package lt.petuska.genesise.controllers;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

/**
 * No Description.
 *
 * @author Martynas Petuska (mpetuska)
 * @since March 2018
 */
@Component
public class Index
{
	@Resource
	private DataSource dataSource;

	public void onAction()
	{
		System.out.println("Click!");
	}
}
