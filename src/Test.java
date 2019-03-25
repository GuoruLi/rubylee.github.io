

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.beans.StringBean;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.HeadingTag;
import org.htmlparser.tags.Span;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

public class Test {

	/*
     * 获得标签中内容
     */
    public static String getTagContent(String tagType, NodeFilter nodeFilter, Parser parser) {
        String tagContent = "";
        try {
            NodeList nodeList = (NodeList) parser.parse(nodeFilter);
            switch (tagType) {
            
				case "h1":
					for (int i = 0; i < nodeList.size(); i++) {
						HeadingTag headingTag = (HeadingTag) nodeList.elementAt(i);
		            	tagContent = headingTag.getStringText();
		            }
					break;
					
				case "h2":
					for (int i = 0; i < nodeList.size(); i++) {
						HeadingTag headingTag = (HeadingTag) nodeList.elementAt(i);
		            	tagContent = headingTag.getStringText();
		            }
					break;
				
				case "div":
					for (int i = 0; i < nodeList.size(); i++) {
		                Div divTag = (Div) nodeList.elementAt(i);
		                tagContent = divTag.getStringText();
		            }
					break;
				
				case "span":
					for (int i = 0; i < nodeList.size(); i++) {
		                Span spanTag = (Span) nodeList.elementAt(i);
		                tagContent = spanTag.getStringText();
		            }
					break;
	
				case "td":
					for (int i = 0; i < nodeList.size(); i++) {
		            	TableColumn tableColumn = (TableColumn) nodeList.elementAt(i);
		            	tagContent = tableColumn.getStringText();
		            }
					break;
	
				default:
					break;
			}
            
        } catch (ParserException e) {
            e.printStackTrace();
        }

        return tagContent;
    }
	
	
	/**
     * 获取新闻的内容
     * @param newsContentFilter
     * @param parser
     * @return  content 新闻内容
     */
    public static String getNewsContent(NodeFilter newsContentFilter, Parser parser) {
        String content = "";
        StringBuilder builder = new StringBuilder();
        try {
            NodeList newsContentList = (NodeList) parser.parse(newsContentFilter);
            for (int i = 0; i < newsContentList.size(); i++) {
                Div newsContenTag = (Div) newsContentList.elementAt(i);
                builder = builder.append(newsContenTag.getStringText());
            }
            content = builder.toString();  //转换为String 类型。
            if (content != null&&(!content.equals(""))) {
                parser.reset();
                parser = Parser.createParser(content, "utf-8");
                StringBean sb = new StringBean();
                sb.setCollapse(true);
                parser.visitAllNodesWith(sb);
                content = sb.getStrings();
                content = content.replaceAll("\\\".*[a-z].*\\}", "");

            }

        } catch (ParserException e) {
        	e.printStackTrace();
        }

        return content;
    }
	
	public static void parserNews(String url) {
    	
        try {
        	Parser parser = new Parser(url);
        	NodeFilter contentFilter = new AndFilter(new TagNameFilter("div"), new HasAttributeFilter("class", "News_box_Left"));
            parser.reset();
            String newsContent = getNewsContent(contentFilter, parser);
            System.out.println(newsContent);
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }
	
	public static void parserTag(String url) {
        try {
        	Parser parser = new Parser(url);
        	NodeFilter contentFilter = new AndFilter(new TagNameFilter("div"), new HasAttributeFilter("class", "News_box_Left"));
            parser.reset();
            String newsContent = getTagContent("div", contentFilter, parser);
            System.out.println(newsContent);
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		//获得纯文本
		Test.parserNews("http://www.chinaylw.com/ArticleForumList.aspx?sn=88");
		//获得网页标签
//		Test.parserTag("http://www.chinaylw.com/ArticleForumList.aspx?sn=88");
	}
}
