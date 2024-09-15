package space.kingfu.webpage.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(

    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 26.sp,
    ),

    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 34.sp,
    ),

    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 42.sp
    ),

    titleSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,
        lineHeight = 50.sp
    ),

    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp,
        lineHeight = 58.sp
    ),

    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 56.sp,
        lineHeight = 66.sp
    ),

    displaySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 64.sp,
        lineHeight = 74.sp
    ),

    displayMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 72.sp,
        lineHeight = 82.sp
    ),




    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
//@Composable
//fun Testing(){
//    Typography.bodyLarge
//    Text(
//        text = "",
////        style = MaterialTheme.typography.bod
//    )
//}
//
//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun TextTopAppBar(
//    text: String,
//    modifier: Modifier = Modifier,
//    color: Color = colorScheme.inverseSurface,
//    fontSize: TextUnit = 18.sp,
//    fontStyle: FontStyle? = null,
//    fontWeight: FontWeight? = FontWeight.Normal,
//    fontFamily: FontFamily? = null,
//    letterSpacing: TextUnit = TextUnit.Unspecified,
//    textDecoration: TextDecoration? = null,
//    textAlign: TextAlign? = null,
//    lineHeight: TextUnit = TextUnit.Unspecified,
//    overflow: TextOverflow = TextOverflow.Clip,
//    softWrap: Boolean = true,
//    maxLines: Int = 1,
//    minLines: Int = 1,
//    onTextLayout: (TextLayoutResult) -> Unit = {},
//    style: TextStyle = typography.bodyLarge,
//) {
//    Text(
//        text = text,
//        modifier = modifier.basicMarquee(iterations = Int.MAX_VALUE),
//        color = color,
//        fontSize = fontSize,
//        fontStyle = fontStyle,
//        fontWeight = fontWeight,
//        fontFamily = fontFamily,
//        letterSpacing = letterSpacing,
//        textDecoration = textDecoration,
//        textAlign = textAlign,
//        lineHeight = lineHeight,
//        overflow = overflow,
//        softWrap = softWrap,
//        maxLines = maxLines,
//        minLines = minLines,
//        onTextLayout = onTextLayout,
//        style = style
//    )
//}
//
//
//
//@Composable
//fun TextBodyLarge(
//    text: String,
//    modifier: Modifier = Modifier,
//    color: Color = colorScheme.inverseSurface,
//    fontSize: TextUnit = TextUnit.Unspecified,
//    fontStyle: FontStyle? = null,
//    fontWeight: FontWeight? = FontWeight.Normal,
//    fontFamily: FontFamily? = null,
//    letterSpacing: TextUnit = TextUnit.Unspecified,
//    textDecoration: TextDecoration? = null,
//    textAlign: TextAlign? = null,
//    lineHeight: TextUnit = TextUnit.Unspecified,
//    overflow: TextOverflow = TextOverflow.Clip,
//    softWrap: Boolean = true,
//    maxLines: Int = Int.MAX_VALUE,
//    minLines: Int = 1,
//    onTextLayout: (TextLayoutResult) -> Unit = {},
//    style: TextStyle = typography.bodyLarge,
//) {
//    Text(
//        text = text,
//        modifier = modifier,
//        color = color,
//        fontSize = fontSize,
//        fontStyle = fontStyle,
//        fontWeight = fontWeight,
//        fontFamily = fontFamily,
//        letterSpacing = letterSpacing,
//        textDecoration = textDecoration,
//        textAlign = textAlign,
//        lineHeight = lineHeight,
//        overflow = overflow,
//        softWrap = softWrap,
//        maxLines = maxLines,
//        minLines = minLines,
//        onTextLayout = onTextLayout,
//        style = style
//    )
//}
//
//@Composable
//fun TextBodyLargeAnnotatedString(
//    annotatedString: AnnotatedString,
//    modifier: Modifier = Modifier,
//    color: Color = colorScheme.inverseSurface,
//    fontSize: TextUnit = TextUnit.Unspecified,
//    fontStyle: FontStyle? = null,
//    fontWeight: FontWeight? = FontWeight.Normal,
//    fontFamily: FontFamily? = null,
//    letterSpacing: TextUnit = TextUnit.Unspecified,
//    textDecoration: TextDecoration? = null,
//    textAlign: TextAlign? = null,
//    lineHeight: TextUnit = TextUnit.Unspecified,
//    overflow: TextOverflow = TextOverflow.Clip,
//    softWrap: Boolean = true,
//    maxLines: Int = Int.MAX_VALUE,
//    minLines: Int = 1,
//    onTextLayout: (TextLayoutResult) -> Unit = {},
//    style: TextStyle = typography.bodyLarge,
//) {
//    Text(
//        text = annotatedString,
//        modifier = modifier,
//        color = color,
//        fontSize = fontSize,
//        fontStyle = fontStyle,
//        fontWeight = fontWeight,
//        fontFamily = fontFamily,
//        letterSpacing = letterSpacing,
//        textDecoration = textDecoration,
//        textAlign = textAlign,
//        lineHeight = lineHeight,
//        overflow = overflow,
//        softWrap = softWrap,
//        maxLines = maxLines,
//        minLines = minLines,
//        onTextLayout = onTextLayout,
//        style = style
//    )
//}
//
//@Composable
//fun TextBodyMedium(
//    text: String,
//    modifier: Modifier = Modifier,
//    color: Color = colorScheme.inverseSurface,
//    fontSize: TextUnit = TextUnit.Unspecified,
//    fontStyle: FontStyle? = null,
//    fontWeight: FontWeight? = FontWeight.Normal,
//    fontFamily: FontFamily? = null,
//    letterSpacing: TextUnit = TextUnit.Unspecified,
//    textDecoration: TextDecoration? = null,
//    textAlign: TextAlign? = null,
//    lineHeight: TextUnit = TextUnit.Unspecified,
//    overflow: TextOverflow = TextOverflow.Clip,
//    softWrap: Boolean = true,
//    maxLines: Int = Int.MAX_VALUE,
//    minLines: Int = 1,
//    onTextLayout: (TextLayoutResult) -> Unit = {},
//    style: TextStyle = typography.bodyMedium,
//) {
//    Text(
//        text = text,
//        modifier = modifier,
//        color = color,
//        fontSize = fontSize,
//        fontStyle = fontStyle,
//        fontWeight = fontWeight,
//        fontFamily = fontFamily,
//        letterSpacing = letterSpacing,
//        textDecoration = textDecoration,
//        textAlign = textAlign,
//        lineHeight = lineHeight,
//        overflow = overflow,
//        softWrap = softWrap,
//        maxLines = maxLines,
//        minLines = minLines,
//        onTextLayout = onTextLayout,
//        style = style
//    )
//}