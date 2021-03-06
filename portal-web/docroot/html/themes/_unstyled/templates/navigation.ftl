<nav class="${nav_css_class}" id="navigation">
	<h1>
		<span><@liferay.language key="navigation" /></span>
	</h1>

	<ul>
		<#list nav_items as nav_item>
			<#if nav_item.isSelected()>
				<li aria-selected="true" class="selected" id="layout_${nav_item.getLayoutId()}">
			<#else>
				<li id="layout_${nav_item.getLayoutId()}">
			</#if>

				<a href="${nav_item.getURL()}" ${nav_item.getTarget()}><span>${nav_item.icon()} ${nav_item.getName()}</span></a>

				<#if nav_item.hasChildren()>
					<ul class="child-menu">
						<#list nav_item.getChildren() as nav_child>
							<#if nav_child.isSelected()>
								<li aria-selected="true" class="selected" id="layout_${nav_child.getLayoutId()}">
							<#else>
								<li id="layout_${nav_child.getLayoutId()}">
							</#if>

								<a href="${nav_child.getURL()}" ${nav_child.getTarget()}>${nav_child.getName()}</a>
							</li>
						</#list>
					</ul>
				</#if>
			</li>
		</#list>
	</ul>
</nav>