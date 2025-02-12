//@Composable
//fun KingfuspaceCanvas(modifier: Modifier = Modifier) {
//    Canvas(modifier = modifier.size(520.dp)) {
//        // Define stroke properties for the lines.
//        val strokeWidth = 10f
//        val strokeCap = StrokeCap.Round
//
//        // 1. M297.997 217.037V367.035
//        drawLine(
//            color = Color.Black,
//            start = Offset(297.997f, 217.037f),
//            end = Offset(297.997f, 367.035f),
//            strokeWidth = strokeWidth,
//            cap = strokeCap
//        )
//        // 2. M148 367.035H297.997
//        drawLine(
//            color = Color.Black,
//            start = Offset(148f, 367.035f),
//            end = Offset(297.997f, 367.035f),
//            strokeWidth = strokeWidth,
//            cap = strokeCap
//        )
//        // 3. M297.997 217.037L335.495 254.536
//        drawLine(
//            color = Color.Black,
//            start = Offset(297.997f, 217.037f),
//            end = Offset(335.495f, 254.536f),
//            strokeWidth = strokeWidth,
//            cap = strokeCap
//        )
//        // 4. M372.995 142.038L335.496 254.536
//        drawLine(
//            color = Color.Black,
//            start = Offset(372.995f, 142.038f),
//            end = Offset(335.496f, 254.536f),
//            strokeWidth = strokeWidth,
//            cap = strokeCap
//        )
//        // 5. M372.995 142.038V292.036
//        drawLine(
//            color = Color.Black,
//            start = Offset(372.995f, 142.038f),
//            end = Offset(372.995f, 292.036f),
//            strokeWidth = strokeWidth,
//            cap = strokeCap
//        )
//        // 6. M297.997 367.035L372.995 292.036
//        drawLine(
//            color = Color.Black,
//            start = Offset(297.997f, 367.035f),
//            end = Offset(372.995f, 292.036f),
//            strokeWidth = strokeWidth,
//            cap = strokeCap
//        )
//        // 7. M148 217.037V367.035
//        drawLine(
//            color = Color.Black,
//            start = Offset(148f, 217.037f),
//            end = Offset(148f, 367.035f),
//            strokeWidth = strokeWidth,
//            cap = strokeCap
//        )
//        // 8. M222.998 292.036L297.997 217.037
//        drawLine(
//            color = Color.Black,
//            start = Offset(222.998f, 292.036f),
//            end = Offset(297.997f, 217.037f),
//            strokeWidth = strokeWidth,
//            cap = strokeCap
//        )
//        // 9. M148 217.037L222.998 292.036
//        drawLine(
//            color = Color.Black,
//            start = Offset(148f, 217.037f),
//            end = Offset(222.998f, 292.036f),
//            strokeWidth = strokeWidth,
//            cap = strokeCap
//        )
//        // 10. M372.995 142.038L297.997 217.037 (opacity 0.25)
//        drawLine(
//            color = Color.Black.copy(alpha = 0.25f),
//            start = Offset(372.995f, 142.038f),
//            end = Offset(297.997f, 217.037f),
//            strokeWidth = strokeWidth,
//            cap = strokeCap
//        )
//        // 11. M222.998 142.038L297.997 217.037 (opacity 0.25)
//        drawLine(
//            color = Color.Black.copy(alpha = 0.25f),
//            start = Offset(222.998f, 142.038f),
//            end = Offset(297.997f, 217.037f),
//            strokeWidth = strokeWidth,
//            cap = strokeCap
//        )
//        // 12. M222.998 142.038L185.499 254.536 (opacity 0.25)
//        drawLine(
//            color = Color.Black.copy(alpha = 0.25f),
//            start = Offset(222.998f, 142.038f),
//            end = Offset(185.499f, 254.536f),
//            strokeWidth = strokeWidth,
//            cap = strokeCap
//        )
//        // 13. M222.998 142.038V292.036 (opacity 0.25)
//        drawLine(
//            color = Color.Black.copy(alpha = 0.25f),
//            start = Offset(222.998f, 142.038f),
//            end = Offset(222.998f, 292.036f),
//            strokeWidth = strokeWidth,
//            cap = strokeCap
//        )
//    }
//}

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

// Data class for a 3D point.
data class Point3D(val x: Float, val y: Float, val z: Float)

// Extension to convert degrees to radians.
fun Float.toRadians(): Float = this * (PI.toFloat() / 180f)

// Rotate a 3D point around the X-axis.
fun rotateX(point: Point3D, angleDegrees: Float): Point3D {
    val rad = angleDegrees.toRadians()
    val cosA = cos(rad)
    val sinA = sin(rad)
    return Point3D(
        x = point.x,
        y = point.y * cosA - point.z * sinA,
        z = point.y * sinA + point.z * cosA
    )
}

// Rotate a 3D point around the Y-axis.
fun rotateY(point: Point3D, angleDegrees: Float): Point3D {
    val rad = angleDegrees.toRadians()
    val cosA = cos(rad)
    val sinA = sin(rad)
    return Point3D(
        x = point.x * cosA + point.z * sinA,
        y = point.y,
        z = -point.x * sinA + point.z * cosA
    )
}

// Simple perspective projection.
// viewDistance defines the “camera” distance.
fun project(
    point: Point3D,
    canvasWidth: Float,
    canvasHeight: Float,
    viewDistance: Float = 600f
): Offset {
    val factor = viewDistance / (viewDistance + point.z)
    return Offset(
        x = point.x * factor + canvasWidth / 2f,
        y = point.y * factor + canvasHeight / 2f
    )
}

@Composable
fun KingfuspaceCanvas(modifier: Modifier = Modifier) {
    // Animate continuous rotation angles (in degrees) using an infinite transition.
    val infiniteTransition = rememberInfiniteTransition()
    val angleX by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    val angleY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val color = MaterialTheme.colorScheme.inverseSurface

    // Use an adaptive Canvas that fills the width and maintains a 1:1 aspect ratio.
    Canvas(modifier = modifier) {
        // Compute the cube size as 80% of the minimum canvas dimension.
        val cubeSize = min(size.width, size.height) * 0.8f
        val half = cubeSize / 2f

        // Define cube vertices centered at (0,0,0).
        val vertices = listOf(
            // Front face (z = -half)
            Point3D(-half, -half, -half), // 0: front top-left
            Point3D(half, -half, -half),  // 1: front top-right
            Point3D(half, half, -half),   // 2: front bottom-right
            Point3D(-half, half, -half),  // 3: front bottom-left
            // Back face (z = half)
            Point3D(-half, -half, half),  // 4: back top-left
            Point3D(half, -half, half),   // 5: back top-right
            Point3D(half, half, half),    // 6: back bottom-right
            Point3D(-half, half, half)    // 7: back bottom-left
        )

        // Define the cube's 12 edges as pairs of vertex indices.
        val edges = listOf(
            // Front face
            0 to 1, 1 to 2, 2 to 3, 3 to 0,
            // Back face
            4 to 5, 5 to 6, 6 to 7, 7 to 4,
            // Connecting edges
            0 to 4, 1 to 5, 2 to 6, 3 to 7
        )

        // Rotate each vertex around the X and Y axes.
        val rotatedVertices = vertices.map { rotateY(rotateX(it, angleX), angleY) }
        // Compute the min and max z for depth-based opacity.
        val minZ = rotatedVertices.minOf { it.z }
        val maxZ = rotatedVertices.maxOf { it.z }

        // Draw each edge with an opacity that depends on depth.
        for ((startIndex, endIndex) in edges) {
            val start3D = rotatedVertices[startIndex]
            val end3D = rotatedVertices[endIndex]
            val start2D = project(start3D, size.width, size.height)
            val end2D = project(end3D, size.width, size.height)
            val avgZ = (start3D.z + end3D.z) / 2f
            // Closer edges are drawn fully opaque; farther edges are drawn with alpha 0.5.
            val alpha = 1f - ((avgZ - minZ) / (maxZ - minZ)) * 0.5f

            drawLine(
                color = color.copy(alpha = alpha),
                start = start2D,
                end = end2D,
                strokeWidth = cubeSize / 16,
                cap = StrokeCap.Round
            )
        }
    }
}



