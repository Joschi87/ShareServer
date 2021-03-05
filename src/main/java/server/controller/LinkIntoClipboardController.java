package server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkIntoClipboardController {

	@GetMapping(path="/clipboard")
	public String getLinkToClipboard(@RequestParam String link){
		return "<html>"
				+ "<script>"
				+ "function copy(){"
				+ " var copyText = document.getElementById(\"myInput\");\n"
				+ "  copyText.select();\n"
				+ "  copyText.setSelectionRange(0, 99999);\n"
				+ "  document.execCommand(\"copy\");\n"
				+ "  alert(\"Funzt\");}"
				+ " </script>"
				+ "<input id='myInput' value='" + link + "' readonly /><script>copy();</script></html>";
	}
	
}
