package tn.enis.member.common;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class Constants {

	@NoArgsConstructor
	public static final class ErrorMessages {

		public static String loading(String entity) {
			return "Error when loading ".concat(entity);
		}

		public static String searching(String entity) {
			return "Error when searching ".concat(entity);
		}

		public static String saving(String entity) {
			return "Error when saving ".concat(entity);
		}

	}

	@NoArgsConstructor
	public static final class EntitiesNames {

		public static final String MEMBERS = "member";
		public static final String TEACHERS = "Teacher";

	}

}
