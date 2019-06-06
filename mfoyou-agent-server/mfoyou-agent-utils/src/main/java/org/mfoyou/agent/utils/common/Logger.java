package org.mfoyou.agent.utils.common;

import org.slf4j.LoggerFactory;

/**
 * The Class Logger.
 */
public class Logger {

	/** The log. */
	org.slf4j.Logger log;

	/**
	 * Gets the logger.
	 * 
	 * @param clazz
	 *            the clazz
	 * @return the logger
	 */
	public static Logger getLogger(Class<?> clazz) {
		return new Logger(clazz);
	}

	/**
	 * Instantiates a new logger.
	 * 
	 * @param clazz
	 *            the clazz
	 */
	public Logger(Class<?> clazz) {
		log = LoggerFactory.getLogger(clazz);
	}

	/**
	 * Trace.
	 * 
	 * @param message
	 *            the message
	 */
	public void trace(String message) {
		log.trace(message);
	}

	/**
	 * Debug.
	 * 
	 * @param message
	 *            the message
	 */
	public void debug(String message) {
		log.debug(message);
	}

	/**
	 * Info.
	 * 
	 * @param message
	 *            the message
	 */
	public void info(String message) {
		log.info(message);
	}

	/**
	 * Warn.
	 * 
	 * @param message
	 *            the message
	 */
	public void warn(String message) {
		log.warn(message);
	}

	/**
	 * Warn.
	 * 
	 * @param message
	 *            the message
	 * @param e
	 *            the e
	 */
	public void warn(String message, Exception e) {
		log.warn(message, e);
	}

	/**
	 * Error.
	 * 
	 * @param message
	 *            the message
	 */
	public void error(String message) {
		log.error(message);
	}

	/**
	 * Error.
	 * 
	 * @param message
	 *            the message
	 * @param e
	 *            the e
	 */
	public void error(String message, Exception e) {
		log.error(message, e);
	}

}
