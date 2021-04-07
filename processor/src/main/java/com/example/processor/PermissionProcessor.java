package com.example.processor;
/**
 * @author lyj on 2021/4/4
 */

import com.google.auto.service.AutoService;
import com.example.processor.annonation.RuntimePermissions;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;


@AutoService(Processor.class)
public class PermissionProcessor extends AbstractProcessor {

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		Set<String> supportTypes = new LinkedHashSet<>();
		supportTypes.add(RuntimePermissions.class.getCanonicalName());
		return supportTypes;
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
		// 创建Java类【你的类名】
		TypeSpec autoClass = TypeSpec.classBuilder("AutoClass").addModifiers(Modifier.PUBLIC).build();

		// 创建Java文档【这里定义了你的包名，随便写即可】
		JavaFile javaFile = JavaFile.builder("com.apt.demo", autoClass).build();

		// 将文档写入
		try {
			javaFile.writeTo(processingEnv.getFiler());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
}
