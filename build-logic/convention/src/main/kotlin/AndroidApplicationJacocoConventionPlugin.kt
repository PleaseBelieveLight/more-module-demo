import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.yyzy.logic.configureJacoco
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/**
 * Android application jacoco convention plugin
 * JaCoCo 插件 是 JaCoCo 工具在 Gradle 构建系统中的集成方式。通过在 Gradle 项目中应用 JaCoCo 插件，
 * 你可以方便地在构建过程中自动进行代码覆盖率分析， 并生成相应的报告。
 * 代码覆盖率是一种衡量测试质量的指标，它表示你的测试代码执行了多少比例的生产代码。
 * 简单来说， 它告诉你你的测试用例覆盖了多少代码。
 * @constructor Create empty Android application jacoco convention plugin
 */
class AndroidApplicationJacocoConventionPlugin : BasePlugin() {
    override fun applyPlugin(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.gradle.jacoco")
                apply("com.android.application")
            }
            val extension = extensions.getByType<ApplicationAndroidComponentsExtension>()
            configureJacoco(extension)
        }
    }
}