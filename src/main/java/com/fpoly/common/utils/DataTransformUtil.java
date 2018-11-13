
package com.fpoly.common.utils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class DataTransformUtil {
	private DataTransformUtil() {
	}

	/**
	 * Transform object from a type to another type
	 *
	 * @param source
	 *            Source object
	 * @param destination
	 *            Target type
	 *
	 * @return Transformed object
	 */
	public static void transform(Object source, Object destination) {

		if (destination == null) {
			return;
		}

		try {

			// Copy all properties
			BeanUtils.copyProperties(destination, source);

		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Create object with type from another object
	 *
	 * @param source
	 *            Source object
	 * @param targetType
	 *            Target type
	 *
	 * @return Transformed object
	 */
	public static Object transform(Object source, Class targetType) {

		try {

			// Instance result object
			Object result = targetType.newInstance();

			// Transform object
			transform(source, result);

			// Return result object
			return result;

		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
