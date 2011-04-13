class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		// default setting:
		//"/"(view:"/index")

		// jump directly into the wizard
		// for the nbic hackaton demo
		"/"(controller: 'investigation')

		"500"(view:'/error')
	}
}
