package com.example.processor;
/**
 * @author lyj on 2021/4/4
 */

import java.io.IOException;
import java.io.Writer;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

//指定处理的注解范围
@SupportedAnnotationTypes("com.example.processor.RuntimePermissions")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class PermissionProcessor extends AbstractProcessor {
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
		System.out.println("process");
		for (Element element : roundEnvironment.getElementsAnnotatedWith(RuntimePermissions.class)) {
			String objectType = element.getSimpleName().toString();
			StringBuilder builder = new StringBuilder()
					.append("package com.example.chenchubin.myprocessor;\n\n")
					.append("public class " + objectType + "PermissionsDispatcher" + " {\n\n")
					.append("\tpublic String withCheck() {\n")
					.append("\t\treturn \"");

			builder.append(objectType + "PermissionsDispatcher").append(" create successfully!!!\\n");

			builder.append("\";\n")
					.append("\t}\n")
					.append("}\n");

			// 写入Java文件 2017/4/19 11:10
			try {
				JavaFileObject source = processingEnv.getFiler()
						.createSourceFile("com.example.chenchubin.myprocessor." + objectType + "PermissionsDispatcher");
				Writer writer = source.openWriter();
				writer.write(builder.toString());
				writer.flush();
				writer.close();
			} catch (IOException e) {

			}
		}
		return true;
	}
}
